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
import org.eclipse.emf.common.util.BasicDiagnostic
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EObjectValidator
import org.safe4i.usf.core.usfmodel.common.Identifiable
import java.util.UUID

/**
 * EMF Validator class for USF-specific validation rules.
 * 
 * @author Klaus Birken (itemis AG) 
 */
abstract class USFAbstractValidator extends EObjectValidator {	
	val public static String DIAGNOSTIC_SOURCE = "org.safe4i.usfmodel";
	
	override boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		var isSuccess = true
		
		// Workaround for legacy models. If no id is set, set one.
		if (value instanceof Identifiable) {
			var id = value as Identifiable
			if (id.uniqueIdentifier === null || id.uniqueIdentifier == "") {
				id.uniqueIdentifier = UUID.randomUUID.toString;
				//diagnostics.addInfo(USF__ADDED_UUID, id, "Added UUID")
			}
		}
		
		if (value instanceof EObject) {
			isSuccess = validate_EveryDefaultConstraint(value, diagnostics, context);
		}

		if (isSuccess) {
			// call dispatcher method
			isSuccess = value.validateObject(classifierID, diagnostics, context)
		}
		isSuccess
	}

	abstract def boolean validateObject(Object other, int classifierID, DiagnosticChain diagnostics,
		Map<Object, Object> context)

	def addError(
		DiagnosticChain diagnostics,
		int code,
		EObject eObject,
		String message
	) {
		if (diagnostics !== null) {
			diagnostics.add(
				new BasicDiagnostic(
					Diagnostic.ERROR,
					DIAGNOSTIC_SOURCE,
					code,
					message,
					#{eObject}
				)
			)
		}
		false
	}
	
	def addWarning(
		DiagnosticChain diagnostics,
		int code,
		EObject eObject,
		String message
	) {
		if (diagnostics !== null) {
			diagnostics.add(
				new BasicDiagnostic(
					Diagnostic.WARNING,
					DIAGNOSTIC_SOURCE,
					code,
					message,
					#{eObject}
				)
			)
		}
		false
	}
	
	
	def addInfo(
		DiagnosticChain diagnostics,
		int code,
		EObject eObject,
		String message
	) {
		if (diagnostics !== null) {
			diagnostics.add(
				new BasicDiagnostic(
					Diagnostic.INFO,
					DIAGNOSTIC_SOURCE,
					code,
					message,
					#{eObject}
				)
			)
		}
		false
	}
}
