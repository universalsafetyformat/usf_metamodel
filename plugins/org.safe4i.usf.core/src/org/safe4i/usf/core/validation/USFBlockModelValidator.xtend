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

import java.util.Map
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EPackage
import org.safe4i.usf.core.usfmodel.block.AssemblyDataFlowConnection
import org.safe4i.usf.core.usfmodel.block.BlockType
import org.safe4i.usf.core.usfmodel.block.BlocksPackage
import org.safe4i.usf.core.usfmodel.block.DataFlowConnection
import org.safe4i.usf.core.usfmodel.block.DelegateDataFlowConnection
import org.safe4i.usf.core.usfmodel.block.PortDirection

/**
 * EMF Validator class for USF-specific validation rules.
 * 
 * @author Klaus Birken (itemis AG) 
 */
class USFBlockModelValidator extends USFAbstractValidator {
	val public static int USF__INVALID_BLOCK = 201;
	val public static int USF__INVALID_PORT = 202;
	val public static int USF__INVALID_DIRECTION = 203;
	val public static int USF__INVALID_PORT_TYPES = 204;

	override EPackage getEPackage() {
		BlocksPackage.eINSTANCE
	}
	
	def private boolean validateDFType(DataFlowConnection conn, int classifierID, DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		var isSuccess = true

		if (conn.sourcePort.type != conn.destinationPort.type) {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT_TYPES,
				conn,
				"DataFlowConnection between port '" + conn.sourcePort.name + "' and port '" +
					conn.destinationPort.name + "' has mismatched types."
			)
		}

		isSuccess
	}

	def dispatch boolean validateObject(DelegateDataFlowConnection conn, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = validateDFType(conn, classifierID, diagnostics, context)

		if (conn.sourcePort.direction != conn.destinationPort.direction ||
			conn.sourcePort.direction == PortDirection::UNSET) {
			isSuccess = diagnostics.addError(
				USF__INVALID_DIRECTION,
				conn,
				"Invalid port directions on connection between ports '" + conn.sourcePort.name + "' and '" +
					conn.destinationPort.name + "'"
			)
		}

		if (conn.innerBlock.eContainer != conn.eContainer) {
			isSuccess = diagnostics.addError(
				USF__INVALID_BLOCK,
				conn,
				"Inner block '" + conn.innerBlock.name + "' is not part of the parent block type '" +
					(conn.eContainer as BlockType).name + "'"
			)
		}
		if (conn.sourcePort.eContainer == conn.innerBlock.type) {
			if (conn.destinationPort.eContainer != conn.eContainer) {
				isSuccess = diagnostics.addError(
					USF__INVALID_PORT,
					conn,
					"Destination port is not connected to the parent block '" + conn.destinationPort.name + "'"
				)
			} else if (conn.destinationPort.direction == PortDirection::IN) {
				isSuccess = diagnostics.addError(
					USF__INVALID_DIRECTION,
					conn,
					"Connection has the wrong direction between ports '" + conn.sourcePort.name + "' and '" +
						conn.destinationPort.name + "'"
				)
			}
		} else if (conn.destinationPort.eContainer == conn.innerBlock.type) {
			if (conn.sourcePort.eContainer != conn.eContainer) {
				isSuccess = diagnostics.addError(
					USF__INVALID_PORT,
					conn,
					"Source port is not connected to the parent block '" + conn.sourcePort.name + "'"
				)
			} else if (conn.destinationPort.direction == PortDirection::OUT) {
				isSuccess = diagnostics.addError(
					USF__INVALID_DIRECTION,
					conn,
					"Connection has the wrong direction between ports '" + conn.sourcePort.name + "' and '" +
						conn.destinationPort.name + "'"
				)
			}
		} else {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT,
				conn,
				"No port is connected to the inner block '" + conn.innerBlock.name + "'"
			)
		}

		isSuccess
	}

	def dispatch boolean validateObject(AssemblyDataFlowConnection conn, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = validateDFType(conn, classifierID, diagnostics, context)

		if (!
			(conn.sourcePort.direction == PortDirection::INOUT &&
			conn.destinationPort.direction == PortDirection::INOUT ||
			conn.sourcePort.direction == PortDirection::OUT && conn.destinationPort.direction == PortDirection::IN)) {
			isSuccess = diagnostics.addError(
				USF__INVALID_DIRECTION,
				conn,
				"Invalid port directions on connection between ports '" + conn.sourcePort.name + "' and '" +
					conn.destinationPort.name + "'"
			)
		}
		if (conn.sourceBlock.eContainer != conn.eContainer) {
			isSuccess = diagnostics.addError(
				USF__INVALID_BLOCK,
				conn,
				"Source block '" + conn.sourceBlock.name + "' is not part of the parent block type '" +
					(conn.eContainer as BlockType).name + "'"
			)
		}
		if (conn.sourcePort.eContainer != conn.sourceBlock.type) {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT,
				conn,
				"Source port  '" + conn.sourcePort.name + "' is not part of the block '" + conn.sourceBlock.name + "'"
			)
		}
		if (conn.destinationBlock.eContainer != conn.eContainer) {
			isSuccess = diagnostics.addError(
				USF__INVALID_BLOCK,
				conn,
				"Destination block '" + conn.destinationBlock.name + "' is not part of the parent block type '" +
					(conn.eContainer as BlockType).name + "'"
			)
		}
		if (conn.destinationPort.eContainer != conn.destinationBlock.type) {
			isSuccess = diagnostics.addError(
				USF__INVALID_PORT,
				conn,
				"Destination port  '" + conn.destinationPort.name + "' is not part of the block '" +
					conn.destinationBlock.name + "'"
			)
		}

		isSuccess
	}
	
	// catch-all
	def dispatch boolean validateObject(Object other, int classifierID, DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		true
	}
}
