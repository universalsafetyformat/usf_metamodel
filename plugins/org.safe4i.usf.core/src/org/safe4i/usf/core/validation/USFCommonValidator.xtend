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
import org.safe4i.usf.core.usfmodel.common.CommonsPackage

/**
 * EMF Validator class for USF-specific validation rules.
 * 
 * @author Klaus Birken (itemis AG) 
 */
class USFCommonValidator extends USFAbstractValidator {

	val public static int USF__ADDED_UUID = 101;

	override EPackage getEPackage() {
		CommonsPackage.eINSTANCE
	}

	// catch-all
	override boolean validateObject(Object other, int classifierID, DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		true
	}
}
