/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */

package org.safe4i.usf.core.tests

import java.io.IOException
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.Diagnostician

class USFTestUtil {

	def static void saveModel(EObject el, String fileLocation) {
		val resSet = new ResourceSetImpl
		val res = resSet.createResource(URI.createFileURI(fileLocation))

		res.contents.add(el)
		try {
			res.save(null)
		} catch (IOException e) {
			e.printStackTrace()
		}

	}

	def static EObject loadModel(String fileLocation) {
		val resSet = new ResourceSetImpl

		// load resource
		val resource = resSet.getResource(URI.createURI(fileLocation), true)
		resource.contents.get(0)
	}

	def static boolean hasErrors(EObject el) {
		val diagnostic = Diagnostician.INSTANCE.validate(el)
		val severity = diagnostic.severity
		var nErrors = 0
		if (severity === Diagnostic.ERROR || severity === Diagnostic.WARNING) {
			for (Diagnostic diag : diagnostic.getChildren()) {
				switch (diag.severity) {
					case Diagnostic.ERROR: {
						nErrors++
						System.err.println('''Validation error: «diag.getMessage()»''')
					}
					case Diagnostic.WARNING: {
						System.err.println('''Validation warning: «diag.getMessage()»''')
					}
				}
			}
		}
		nErrors !== 0
	}
}
