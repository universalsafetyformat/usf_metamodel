/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */

package org.safe4i.usf.core.usfmodel.controlFlow.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.safe4i.usf.core.usfmodel.block.BlocksFactory;
import org.safe4i.usf.core.usfmodel.block.provider.AbstractBlockTypeItemProvider;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowsFactory;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowsPackage;
import org.safe4i.usf.core.usfmodel.controlFlow.DecisionNode;
import org.safe4i.usf.core.usfmodel.errorHandling.ErrorHandlingFactory;

/**
 * This is the item provider adapter for a {@link org.safe4i.usf.core.usfmodel.controlFlow.DecisionNode} object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DecisionNodeItemProvider extends AbstractBlockTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DecisionNodeItemProvider(AdapterFactory adapterFactory) {
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

			addConditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Condition feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_DecisionNode_condition_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_condition_feature", "_UI_DecisionNode_type"),
				ControlFlowsPackage.Literals.DECISION_NODE__CONDITION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ControlFlowsPackage.Literals.DECISION_NODE__IN_CONTROL_FLOW_PORT);
			childrenFeatures.add(ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_TRUE);
			childrenFeatures.add(ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_FALSE);
			childrenFeatures.add(ControlFlowsPackage.Literals.DECISION_NODE__IN_DATA_FLOW_PORTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DecisionNode.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DecisionNode"));
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

		switch (notification.getFeatureID(DecisionNode.class)) {
		case ControlFlowsPackage.DECISION_NODE__CONDITION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ControlFlowsPackage.DECISION_NODE__IN_CONTROL_FLOW_PORT:
		case ControlFlowsPackage.DECISION_NODE__OUT_CONTROL_FLOW_PORT_TRUE:
		case ControlFlowsPackage.DECISION_NODE__OUT_CONTROL_FLOW_PORT_FALSE:
		case ControlFlowsPackage.DECISION_NODE__IN_DATA_FLOW_PORTS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add(
				createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__IN_CONTROL_FLOW_PORT, ControlFlowsFactory.eINSTANCE.createControlFlowPort()));

		newChildDescriptors.add(createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__IN_CONTROL_FLOW_PORT,
				ErrorHandlingFactory.eINSTANCE.createErrorControlFlowPort()));

		newChildDescriptors.add(createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_TRUE,
				ControlFlowsFactory.eINSTANCE.createControlFlowPort()));

		newChildDescriptors.add(createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_TRUE,
				ErrorHandlingFactory.eINSTANCE.createErrorControlFlowPort()));

		newChildDescriptors.add(createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_FALSE,
				ControlFlowsFactory.eINSTANCE.createControlFlowPort()));

		newChildDescriptors.add(createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_FALSE,
				ErrorHandlingFactory.eINSTANCE.createErrorControlFlowPort()));

		newChildDescriptors
				.add(createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__IN_DATA_FLOW_PORTS, BlocksFactory.eINSTANCE.createDataFlowPort()));

		newChildDescriptors.add(
				createChildParameter(ControlFlowsPackage.Literals.DECISION_NODE__IN_DATA_FLOW_PORTS, ErrorHandlingFactory.eINSTANCE.createErrorDataPort()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		final Object childFeature = feature;
		final Object childObject = child;

		final boolean qualify = childFeature == ControlFlowsPackage.Literals.DECISION_NODE__IN_CONTROL_FLOW_PORT
				|| childFeature == ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_TRUE
				|| childFeature == ControlFlowsPackage.Literals.DECISION_NODE__OUT_CONTROL_FLOW_PORT_FALSE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
