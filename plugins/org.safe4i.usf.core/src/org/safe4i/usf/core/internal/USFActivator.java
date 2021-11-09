/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.core.internal;

import org.safe4i.usf.core.USFModelRuntime;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * Activator for this plugin which registers the SAFE4I USF model.
 */
public class USFActivator extends Plugin {

	public static final String PLUGIN_NAME = "org.safe4i.usf.core.internal.USFActivator";
	
	private static USFActivator INSTANCE;
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		
		USFModelRuntime.init();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}
	
	public static USFActivator getInstance() {
		return INSTANCE;
	}
	
}
