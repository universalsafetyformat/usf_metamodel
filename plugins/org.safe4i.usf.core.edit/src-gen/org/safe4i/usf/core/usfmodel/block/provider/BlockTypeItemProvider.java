/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.core.usfmodel.block.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.BlocksFactory;
import org.safe4i.usf.core.usfmodel.block.BlocksPackage;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowsFactory;
import org.safe4i.usf.core.usfmodel.errorHandling.ErrorHandlingFactory;

/**
 * This is the item provider adapter for a {@link org.safe4i.usf.core.usfmodel.block.BlockType} object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class BlockTypeItemProvider extends AbstractBlockTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BlockTypeItemProvider(AdapterFactory adapterFactory) {
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

			addDocumentationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Documentation feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDocumentationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_DocumentedElement_documentation_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DocumentedElement_documentation_feature", "_UI_DocumentedElement_type"),
				CommonsPackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(BlocksPackage.Literals.BLOCK_TYPE__BLOCKS);
			childrenFeatures.add(BlocksPackage.Literals.BLOCK_TYPE__DATA_FLOW_PORTS);
			childrenFeatures.add(BlocksPackage.Literals.BLOCK_TYPE__DATA_FLOW_CONNECTIONS);
			childrenFeatures.add(BlocksPackage.Literals.BLOCK_TYPE__CONTROL_FLOW_PORTS);
			childrenFeatures.add(BlocksPackage.Literals.BLOCK_TYPE__CONTROL_FLOW_CONNECTIONS);
			childrenFeatures.add(BlocksPackage.Literals.BLOCK_TYPE__BLOCK_RELATIONSHIPS);
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
	 * This returns BlockType.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BlockType"));
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

		switch (notification.getFeatureID(BlockType.class)) {
		case BlocksPackage.BLOCK_TYPE__DOCUMENTATION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case BlocksPackage.BLOCK_TYPE__BLOCKS:
		case BlocksPackage.BLOCK_TYPE__DATA_FLOW_PORTS:
		case BlocksPackage.BLOCK_TYPE__DATA_FLOW_CONNECTIONS:
		case BlocksPackage.BLOCK_TYPE__CONTROL_FLOW_PORTS:
		case BlocksPackage.BLOCK_TYPE__CONTROL_FLOW_CONNECTIONS:
		case BlocksPackage.BLOCK_TYPE__BLOCK_RELATIONSHIPS:
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

		newChildDescriptors.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__BLOCKS, BlocksFactory.eINSTANCE.createBlock()));

		newChildDescriptors.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__DATA_FLOW_PORTS, BlocksFactory.eINSTANCE.createDataFlowPort()));

		newChildDescriptors.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__DATA_FLOW_PORTS, ErrorHandlingFactory.eINSTANCE.createErrorDataPort()));

		newChildDescriptors.add(
				createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__DATA_FLOW_CONNECTIONS, BlocksFactory.eINSTANCE.createAssemblyDataFlowConnection()));

		newChildDescriptors.add(
				createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__DATA_FLOW_CONNECTIONS, BlocksFactory.eINSTANCE.createDelegateDataFlowConnection()));

		newChildDescriptors
				.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__CONTROL_FLOW_PORTS, ControlFlowsFactory.eINSTANCE.createControlFlowPort()));

		newChildDescriptors
				.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__CONTROL_FLOW_PORTS, ErrorHandlingFactory.eINSTANCE.createErrorControlFlowPort()));

		newChildDescriptors.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__CONTROL_FLOW_CONNECTIONS,
				ControlFlowsFactory.eINSTANCE.createAssemblyControlFlowConnection()));

		newChildDescriptors.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__CONTROL_FLOW_CONNECTIONS,
				ControlFlowsFactory.eINSTANCE.createDelegateControlFlowConnection()));

		newChildDescriptors.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__BLOCK_RELATIONSHIPS, BlocksFactory.eINSTANCE.createUseRelationship()));

		newChildDescriptors
				.add(createChildParameter(BlocksPackage.Literals.BLOCK_TYPE__BLOCK_RELATIONSHIPS, BlocksFactory.eINSTANCE.createDeployRelationship()));
	}

}
