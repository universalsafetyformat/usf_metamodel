/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
 package org.safe4i.usf.core.validation

import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EPackage
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage
import java.util.Map
import org.safe4i.usf.core.usfmodel.parameter.TransformationTypeValue
import org.safe4i.usf.core.usfmodel.parameter.TransformationPrimitiveType
import org.safe4i.usf.core.usfmodel.parameter.TransformationTypeParameterDefinition
import org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterValue
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterDefinition
import org.safe4i.usf.core.usfmodel.block.BlockType
import org.eclipse.emf.ecore.EObject
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterDefinition
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterValue
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterValue
import org.safe4i.usf.core.usfmodel.parameter.PortParameterDefinition
import org.safe4i.usf.core.usfmodel.block.PortDirection
import org.safe4i.usf.core.usfmodel.block.Port
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowPort
import org.safe4i.usf.core.usfmodel.block.DataFlowPort
import org.safe4i.usf.core.usfmodel.parameter.PortParameterValue
import org.safe4i.usf.core.usfmodel.common.DomainType
import static org.safe4i.usf.core.validation.USFPortTemplateValidator.checkTypeConstraint
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterDefinition
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowConnection
import org.safe4i.usf.core.usfmodel.block.DataFlowConnection
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterValue
import org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterDefinition

class USFParameterValidator extends USFAbstractValidator {
	val public static int USF__INVALID_TRANSFORMATION_PRIMITVE_TYPE_VALUE = 501;
	val public static int USF__INVALID_TRANSFORMATION_TYPE_PARAMETER = 502;
	val public static int USF__INVALID_TRANSFORMATION_DOMAIN_TYPE_VALUE = 503;
	val public static int USF__INVALID_BLOCKTYPE_CONSTRAINT_VALUE = 504;
	val public static int USF__INVALID_PORT_DIR_CONSTRAINT_VALUE = 505;
	val public static int USF__INVALID_PORT_TYPE_CONSTRAINT_VALUE = 506;
	val public static int USF__INVALID_PORT_CONSTR_TYPE_CONSTRAINT_VALUE = 507;
	val public static int USF__INVALID_CONNECTION_TYPE_CONSTRAINT_VALUE = 508;
	val public static int USF__INVALID_DOMAIN_TYPE_CONSTRAINT_VALUE = 509;

	override EPackage getEPackage() {
		ParametersPackage.eINSTANCE
	}

	def private boolean validateTrafoType(TransformationPrimitiveType type, String value) {
		var lVal = value.toLowerCase
		var success = false
		switch (type) {
			case BOOLEAN: {
				success = (lVal== "true" || lVal == "false")
			}
			case INTEGER: {
				try {
					Integer.parseInt(lVal);
					success = true
				} catch (NumberFormatException e) {}
			}
			case FLOAT: {
				try {
					Float.parseFloat(lVal);
					success = true
				} catch (NumberFormatException e) {}
			}
			case STRING: {
				success = true
			}
			case VOID: {
				success = lVal == ""
			}
		}

		success
	}

	def dispatch boolean validateObject(TransformationTypeValue tValue, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (tValue.parameter.type != TransformationPrimitiveType::VOID && 
			tValue.value.nullOrEmpty && tValue.parameter.defaultValue.nullOrEmpty
		) {
			isSuccess = diagnostics.addError(
				USF__INVALID_TRANSFORMATION_PRIMITVE_TYPE_VALUE,
				tValue,
				"TransformationTypeValue '" + tValue.value + "' neither value nor default is set."
			)
		}

		if (isSuccess && !tValue.value.nullOrEmpty && !validateTrafoType(tValue.parameter.type, tValue.value)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_TRANSFORMATION_PRIMITVE_TYPE_VALUE,
				tValue,
				"TransformationTypeValue '" + tValue.value + "' value is not valid for type " + tValue.parameter.type.toString
			)
		}

		isSuccess
	}

	def dispatch boolean validateObject(TransformationTypeParameterDefinition tType, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (!tType.defaultValue.nullOrEmpty && !validateTrafoType(tType.type, tType.defaultValue)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_TRANSFORMATION_TYPE_PARAMETER,
				tType,
				"TransformationType '" + tType.defaultValue + "' default value is not valid for type " + tType.type.toString
			)
		}

		isSuccess
	}
	
	def private boolean checkBlockTypeConstraint(DiagnosticChain diagnostics, EObject obj,
		BlockType constrBT, BlockType checkBT) {
		var isSuccess = true
		for (dp : constrBT.dataFlowPorts) {
			if (!checkBT.dataFlowPorts.exists[p | p.name == dp.name]) {
				isSuccess = diagnostics.addError(
					USF__INVALID_BLOCKTYPE_CONSTRAINT_VALUE, obj,
					"Missing data port '" + dp.name + "' from constraint block type '"
					+ constrBT.name + "'.")
			}
		}
		for (cp : constrBT.controlFlowPorts) {
			if (!checkBT.dataFlowPorts.exists[p | p.name == cp.name]) {
				isSuccess = diagnostics.addError(
					USF__INVALID_BLOCKTYPE_CONSTRAINT_VALUE, obj,
					"Missing control flow port '" + cp.name + "' from constrain block type '"
					+ constrBT.name + "'.")
			}
		}
		isSuccess
	}
	
	def dispatch boolean validateObject(BlockParameterDefinition bDef, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (bDef.constrainingBlockType !== null && bDef.defaultValue !== null) {
			isSuccess = checkBlockTypeConstraint(diagnostics, bDef,
				bDef.constrainingBlockType, bDef.defaultValue.type as BlockType)
		}

		isSuccess
	}
	
	def dispatch boolean validateObject(BlockParameterValue bVal, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (bVal.parameter.constrainingBlockType !== null) {
			isSuccess = checkBlockTypeConstraint(diagnostics, bVal,
				bVal.parameter.constrainingBlockType, bVal.value.type as BlockType)
		}

		isSuccess
	}
	
	def dispatch boolean validateObject(BlockTypeParameterDefinition btDef, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (btDef.constrainingBlockType !== null && btDef.defaultValue !== null) {
			isSuccess = checkBlockTypeConstraint(diagnostics, btDef,
				btDef.constrainingBlockType, btDef.defaultValue)
		}

		isSuccess
	}
	
	def dispatch boolean validateObject(BlockTypeParameterValue btVal, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (btVal.parameter.constrainingBlockType !== null) {
			isSuccess = checkBlockTypeConstraint(diagnostics, btVal,
				btVal.parameter.constrainingBlockType, btVal.value)
		}

		isSuccess
	}
	
	def private boolean checkPort(DiagnosticChain diagnostics, EObject obj,
		PortParameterDefinition pDef, Port checkPort) {
		var isSuccess = true
		
		if (pDef.constrainingDirection != PortDirection::UNSET 
			&& pDef.constrainingDirection != checkPort.direction) {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT_DIR_CONSTRAINT_VALUE, obj,
				"Port direction constraint requires '" + pDef.constrainingDirection + "' for port.")
		}
		
		if (pDef.controlflowPort && !(checkPort instanceof ControlFlowPort)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT_TYPE_CONSTRAINT_VALUE, obj,
				"Port is not a control flow port.")
		}
		
		if (!pDef.controlflowPort && !(checkPort instanceof DataFlowPort)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT_TYPE_CONSTRAINT_VALUE, obj,
				"Port is not a data flow port.")
		}
		
		isSuccess
	}
	
	def private boolean checkPortType(DiagnosticChain diagnostics, EObject obj,
		DomainType constrType, Port port) {
		var isSuccess = true
		if (!(port instanceof DataFlowPort)) {
			isSuccess = diagnostics.addError(USF__INVALID_PORT_CONSTR_TYPE_CONSTRAINT_VALUE, 
				obj, "Port constraint requires a data flow port.")
			return isSuccess
		}
		
		var portType = (port as DataFlowPort).type				
		if (!checkTypeConstraint(constrType, portType)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT_CONSTR_TYPE_CONSTRAINT_VALUE, obj,				
				"Port type '" + portType.name + "' does not satisfies the type constraint '" 
					+ constrType.name + "'.")
		}
		
		isSuccess
	}
	
	def dispatch boolean validateObject(PortParameterDefinition pDef, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (pDef.defaultValue !== null) {
			isSuccess = checkPort(diagnostics, pDef, pDef, pDef.defaultValue)
		}
		
		if (pDef.constrainingPortType !== null) {
			if (pDef.isControlflowPort) {
				isSuccess = diagnostics.addError(
					USF__INVALID_PORT_CONSTR_TYPE_CONSTRAINT_VALUE, pDef,
					"Port type constraints can't be set for control flow ports.")
			}
			
			if (pDef.defaultValue !== null){
				isSuccess = checkPortType(diagnostics, pDef, 
					pDef.constrainingPortType, pDef.defaultValue)
			}
		}

		isSuccess
	}
	
	def dispatch boolean validateObject(PortParameterValue pVal, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (pVal.parameter.defaultValue !== null) {
			isSuccess = checkPort(diagnostics, pVal, pVal.parameter, pVal.value)
		}
		
		if (pVal.parameter.constrainingPortType !== null) {
			isSuccess = checkPortType(diagnostics, pVal, pVal.parameter.constrainingPortType,
				pVal.value
			)
		}

		isSuccess
	}
	
	def dispatch boolean validateObject(ConnectionParameterDefinition cDef, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (cDef.defaultValue !== null) {
			if (cDef.controlflowConnection && !(cDef.defaultValue instanceof ControlFlowConnection)) {
				isSuccess = diagnostics.addError(
					USF__INVALID_CONNECTION_TYPE_CONSTRAINT_VALUE, cDef,
					"Connection has to be a control flow connection.")
			}
			if (!cDef.controlflowConnection && !(cDef.defaultValue instanceof DataFlowConnection)) {
				isSuccess = diagnostics.addError(
					USF__INVALID_CONNECTION_TYPE_CONSTRAINT_VALUE, cDef,
					"Connection has to be a data flow connection.")
			}
		}

		isSuccess
	}
	
	def dispatch boolean validateObject(ConnectionParameterValue cVal, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (cVal.parameter.controlflowConnection && !(cVal.value instanceof ControlFlowConnection)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_CONNECTION_TYPE_CONSTRAINT_VALUE, cVal,
				"Connection has to be a control flow connection.")
		}
		if (cVal.parameter.controlflowConnection && !(cVal.value instanceof DataFlowConnection)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_CONNECTION_TYPE_CONSTRAINT_VALUE, cVal,
				"Connection has to be a data flow connection.")
		}
		
		isSuccess
	}
	
	def dispatch boolean validateObject(DomainTypeParameterDefinition dParam, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true

		if (dParam.constrainingDomainType !== null && dParam.defaultValue !== null) {
			if (!checkTypeConstraint(dParam.constrainingDomainType, dParam.defaultValue)) {
				isSuccess = diagnostics.addError(
					USF__INVALID_DOMAIN_TYPE_CONSTRAINT_VALUE, dParam,
					"Domain type '" + dParam.defaultValue.name + "' does not satisfies the type constraint '" 
					+ dParam.constrainingDomainType.name + "'.")
			}
		}
		
		isSuccess
	}
	
	def dispatch boolean validateObject(DomainTypeParameterValue dVal, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true
		
		if (dVal.value === null && dVal.parameter.defaultValue === null) {
			isSuccess = diagnostics.addError(
				USF__INVALID_TRANSFORMATION_DOMAIN_TYPE_VALUE, dVal,
				"DomainTypeParameterValue '" + dVal.value + "' neither value nor default is set."
			)
		}

		if (dVal.parameter.constrainingDomainType !== null) {
			if (!checkTypeConstraint(dVal.parameter.constrainingDomainType, dVal.value)) {
				isSuccess = diagnostics.addError(
					USF__INVALID_DOMAIN_TYPE_CONSTRAINT_VALUE, dVal,
					"Domain type '" + dVal.value.name + "' does not satisfies the type constraint '" 
					+ dVal.parameter.constrainingDomainType.name + "'.")
			}
		}
		
		isSuccess
	}

	// catch-all
	def dispatch boolean validateObject(Object other, int classifierID, DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		true
	}
}
