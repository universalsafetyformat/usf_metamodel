/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.core.usfmodel.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

public enum LabelProviderHelper {
	INSTANCE;

	public static final String UNSET_LITERAL = "<Unset>";
	public static final String NO_NAME_LITERAL = "<No Name>";
	public static final String INVALID_LITERAL = "<Invalid>";

	private ComposedAdapterFactory composedAdapterFactory = null;

	public Object getImageFromObject(Object object) {
		if (composedAdapterFactory == null) {
			composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		final IItemLabelProvider itemLabelProvider = (IItemLabelProvider) composedAdapterFactory.adapt(object, IItemLabelProvider.class);
		return itemLabelProvider.getImage(object);
	}

	public String beautifyCamelCaseString(String text) {
		if (text == null) {
			return "";
		}
		return format(capName(text), ' ');
	}

	private String capName(String name) {
		return name.length() == 0 ? name : name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private String format(String name, char separator) {
		final StringBuilder result = new StringBuilder();

		for (final Iterator<String> i = parseName(name, '_').iterator(); i.hasNext();) {
			final String component = i.next();
			result.append(component);
			if (i.hasNext() && component.length() > 1) {
				result.append(separator);
			}
		}
		return result.toString();
	}

	private List<String> parseName(String sourceName, char sourceSeparator) {
		final List<String> result = new ArrayList<>();
		StringBuffer currentWord = new StringBuffer();

		final int length = sourceName.length();
		boolean lastIsLower = false;

		for (int index = 0; index < length; index++) {
			final char curChar = sourceName.charAt(index);
			if (Character.isUpperCase(curChar) || (!lastIsLower && Character.isDigit(curChar)) || curChar == sourceSeparator) {
				if (lastIsLower || curChar == sourceSeparator) {
					result.add(currentWord.toString());
					currentWord = new StringBuffer();
				}
				lastIsLower = false;
			} else {
				if (!lastIsLower) {
					int currentWordLength = currentWord.length();
					if (currentWordLength > 1) {
						final char lastChar = currentWord.charAt(--currentWordLength);
						currentWord.setLength(currentWordLength);
						result.add(currentWord.toString());
						currentWord = new StringBuffer();
						currentWord.append(lastChar);
					}
				}
				lastIsLower = true;
			}
			if (curChar != sourceSeparator) {
				currentWord.append(curChar);
			}
		}

		result.add(currentWord.toString());
		return result;
	}

}
