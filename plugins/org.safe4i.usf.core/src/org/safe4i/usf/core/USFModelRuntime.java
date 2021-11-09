/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.core;

import java.util.Map;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.safe4i.usf.core.usfmodel.block.BlocksPackage;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowsPackage;
import org.safe4i.usf.core.usfmodel.errorHandling.ErrorHandlingPackage;
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage;
import org.safe4i.usf.core.usfmodel.portTemplate.PortTemplatesPackage;
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPatternPackage;
import org.safe4i.usf.core.validation.USFBlockModelValidator;
import org.safe4i.usf.core.validation.USFCommonValidator;
import org.safe4i.usf.core.validation.USFControlFlowBlockValidator;
import org.safe4i.usf.core.validation.USFErrorHandlingValidator;
import org.safe4i.usf.core.validation.USFParameterValidator;
import org.safe4i.usf.core.validation.USFPortTemplateValidator;
import org.safe4i.usf.core.validation.USFSafetyPatternValidator;

/**
 * Utility for initializing all components of the USF metamodel.
 */
public class USFModelRuntime {

	public static void init() {
		// initialize the model
		CommonsPackage.eINSTANCE.eClass();
		BlocksPackage.eINSTANCE.eClass();
		PortTemplatesPackage.eINSTANCE.eClass();
		ErrorHandlingPackage.eINSTANCE.eClass();
		ControlFlowsPackage.eINSTANCE.eClass();
		SafetyPatternPackage.eINSTANCE.eClass();
		

		// register XMI resource
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		// register specific validator
		EValidator.Registry.INSTANCE.put(CommonsPackage.eINSTANCE, new USFCommonValidator());
		EValidator.Registry.INSTANCE.put(BlocksPackage.eINSTANCE, new USFBlockModelValidator());
		EValidator.Registry.INSTANCE.put(ControlFlowsPackage.eINSTANCE, new USFControlFlowBlockValidator());
		EValidator.Registry.INSTANCE.put(ErrorHandlingPackage.eINSTANCE, new USFErrorHandlingValidator());
		EValidator.Registry.INSTANCE.put(ParametersPackage.eINSTANCE, new USFParameterValidator());
		EValidator.Registry.INSTANCE.put(PortTemplatesPackage.eINSTANCE, new USFPortTemplateValidator());
		EValidator.Registry.INSTANCE.put(SafetyPatternPackage.eINSTANCE, new USFSafetyPatternValidator());

	}
}
