/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */

package org.safe4i.usf.core.usfmodel.parameter.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.TransformationArgument;
import org.safe4i.usf.core.usfmodel.parameter.TransformationTypeValue;
import org.safe4i.usf.core.usfmodel.util.LabelProviderHelper;

/**
 * This is the item provider adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.TransformationArgument} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class TransformationArgumentItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransformationArgumentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addUniqueIdentifierPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Unique Identifier feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addUniqueIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Identifiable_uniqueIdentifier_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Identifiable_uniqueIdentifier_feature", "_UI_Identifiable_type"),
				CommonsPackage.Literals.IDENTIFIABLE__UNIQUE_IDENTIFIER, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		final TransformationArgument element = (TransformationArgument) object;
		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(element.eClass().getName());

		if (element instanceof BlockParameterValue) {
			final BlockParameterValue bpv = (BlockParameterValue) object;
			return "[" + eClassName + "] " + (bpv.getValue() != null ? bpv.getValue().getName() : "No Value");
		} else if (element instanceof BlockTypeParameterValue) {
			final BlockTypeParameterValue btpv = (BlockTypeParameterValue) object;
			return "[" + eClassName + "] " + (btpv.getValue() != null ? btpv.getValue().getName() : "No Value");
		} else if (element instanceof PortParameterValue) {
			final PortParameterValue ppv = (PortParameterValue) object;
			return "[" + eClassName + "] " + (ppv.getValue() != null ? ppv.getValue().getName() : "No Value");
		} else if (element instanceof ConnectionParameterValue) {
			return "[" + eClassName + "]";
		} else if (element instanceof DomainTypeParameterValue) {
			final DomainTypeParameterValue dObj = (DomainTypeParameterValue) object;
			return "[" + eClassName + "] " + (dObj.getValue() != null ? dObj.getValue().getName() : "No Value");
		} else if (element instanceof TransformationTypeValue) {
			final TransformationTypeValue tObj = (TransformationTypeValue) object;
			return "[" + eClassName + "] " + (tObj.getValue() != null ? tObj.getValue() : "No Value");
		} else {
			return "[" + eClassName + "]";
		}
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating a viewer notification, which it passes
	 * to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TransformationArgument.class)) {
		case ParametersPackage.TRANSFORMATION_ARGUMENT__UNIQUE_IDENTIFIER:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created under this object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ((IChildCreationExtender) adapterFactory).getResourceLocator();
	}

}
