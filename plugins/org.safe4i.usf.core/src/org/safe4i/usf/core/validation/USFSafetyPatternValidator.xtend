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

import org.eclipse.emf.ecore.EPackage
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPatternPackage
import java.util.Map
import org.eclipse.emf.common.util.DiagnosticChain
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPatternApplication

class USFSafetyPatternValidator extends USFAbstractValidator {
	val public static int USF__INVALID_SAFETY_PATTERN_APPLICATION_ARGUMENT = 701;

	override EPackage getEPackage() {
		SafetyPatternPackage.eINSTANCE
	}
	
	
	def dispatch boolean validateObject(SafetyPatternApplication spa, int classifierID,
		DiagnosticChain diagnostics, Map<Object, Object> context) {
		var isSuccess = true
		
		for (bp : spa.blockParameterArguments) {
			if (!spa.type.blockParameters.contains(bp.parameter)) {
				isSuccess = diagnostics.addError(USF__INVALID_SAFETY_PATTERN_APPLICATION_ARGUMENT, bp,
					"BlockParameterValue '" + bp + "' is not part of the type.")
			}
		}
		for (btp : spa.blockTypeParameterArguments) {
			if (!spa.type.blockTypeParameters.contains(btp.parameter)) {
				isSuccess = diagnostics.addError(USF__INVALID_SAFETY_PATTERN_APPLICATION_ARGUMENT, btp,
					"BlockTypeParameterValue '" + btp + "' is not part of the type.")
			}
		}
		for (cp : spa.connectionParameterArguments) {
			if (!spa.type.connectionParameters.contains(cp.parameter)) {
				isSuccess = diagnostics.addError(USF__INVALID_SAFETY_PATTERN_APPLICATION_ARGUMENT, cp,
					"ConnectionParameterValue '" + cp + "' is not part of the type.")
			}
		}
		for (pp : spa.portParameterArguments) {
			if (!spa.type.portParameters.contains(pp.parameter)) {
				isSuccess = diagnostics.addError(USF__INVALID_SAFETY_PATTERN_APPLICATION_ARGUMENT, pp,
					"PortParameterValue '" + pp + "' is not part of the type.")
			}
		}
		for (tt : spa.trafoTypeArguments) {
			if (!spa.type.trafoTypeParameterDefinitions.contains(tt.parameter)) {
				isSuccess = diagnostics.addError(USF__INVALID_SAFETY_PATTERN_APPLICATION_ARGUMENT, tt,
					"TransformationTypeValue '" + tt + "' is not part of the type.")
			}
		}
		for (dt : spa.domainTypeArguments) {
			if (!spa.type.domainTypeParameterDefinitions.contains(dt.parameter)) {
				isSuccess = diagnostics.addError(USF__INVALID_SAFETY_PATTERN_APPLICATION_ARGUMENT, dt,
					"DomainTypeParameterValue '" + dt + "' is not part of the type.")
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
