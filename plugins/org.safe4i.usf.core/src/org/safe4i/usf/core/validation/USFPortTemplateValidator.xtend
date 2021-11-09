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
import org.safe4i.usf.core.usfmodel.portTemplate.PortTemplatesPackage
import java.util.Map
import org.eclipse.emf.common.util.DiagnosticChain
import org.safe4i.usf.core.usfmodel.common.DomainType
import org.safe4i.usf.core.usfmodel.portTemplate.TemplateType
import org.safe4i.usf.core.usfmodel.common.ArrayType
import org.safe4i.usf.core.usfmodel.common.StructType

class USFPortTemplateValidator extends USFAbstractValidator {

	override EPackage getEPackage() {
		PortTemplatesPackage.eINSTANCE
	}
	
	def static boolean checkTypeConstraint(DomainType constrType, DomainType checkType) {
		if (constrType == checkType || constrType instanceof TemplateType) {
			return true
		}
		if (constrType instanceof ArrayType && checkType instanceof ArrayType) {
			val act = constrType as ArrayType
			val bct = checkType as ArrayType
			return (act.length == bct.length) && checkTypeConstraint(act.type, bct.type)
		}
		
		if (constrType instanceof StructType && checkType instanceof StructType) {
			val act = constrType as StructType
			val bct = checkType as StructType
			for (tm : act.members) {
				val om = bct.members.findFirst[m | m.name == tm.name]
				if (om === null || !checkTypeConstraint(tm.type, om.type)) {
					return false
				}
			}
			return true
		}

		false 
	}

	// catch-all
	override boolean validateObject(Object other, int classifierID, DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		true
	}
}
