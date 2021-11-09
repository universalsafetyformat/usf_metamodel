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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterDefinition;

/**
 * This is the item provider adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.PortParameterDefinition} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class PortParameterDefinitionItemProvider extends ModelParameterDefinitionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PortParameterDefinitionItemProvider(AdapterFactory adapterFactory) {
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

			addConstrainingPortTypePropertyDescriptor(object);
			addDefaultValuePropertyDescriptor(object);
			addConstrainingDirectionPropertyDescriptor(object);
			addControlflowPortPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Constraining Port Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addConstrainingPortTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_PortParameterDefinition_constrainingPortType_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_PortParameterDefinition_constrainingPortType_feature", "_UI_PortParameterDefinition_type"),
				ParametersPackage.Literals.PORT_PARAMETER_DEFINITION__CONSTRAINING_PORT_TYPE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Default Value feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDefaultValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_PortParameterDefinition_defaultValue_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_PortParameterDefinition_defaultValue_feature", "_UI_PortParameterDefinition_type"),
				ParametersPackage.Literals.PORT_PARAMETER_DEFINITION__DEFAULT_VALUE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Constraining Direction feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addConstrainingDirectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_PortParameterDefinition_constrainingDirection_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_PortParameterDefinition_constrainingDirection_feature",
						"_UI_PortParameterDefinition_type"),
				ParametersPackage.Literals.PORT_PARAMETER_DEFINITION__CONSTRAINING_DIRECTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Controlflow Port feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addControlflowPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
						getString("_UI_PortParameterDefinition_controlflowPort_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_PortParameterDefinition_controlflowPort_feature",
								"_UI_PortParameterDefinition_type"),
						ParametersPackage.Literals.PORT_PARAMETER_DEFINITION__CONTROLFLOW_PORT, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
						null, null));
	}

	/**
	 * This returns PortParameterDefinition.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PortParameterDefinition"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
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

		switch (notification.getFeatureID(PortParameterDefinition.class)) {
		case ParametersPackage.PORT_PARAMETER_DEFINITION__CONSTRAINING_DIRECTION:
		case ParametersPackage.PORT_PARAMETER_DEFINITION__CONTROLFLOW_PORT:
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

}
