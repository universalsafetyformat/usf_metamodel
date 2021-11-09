/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */

package org.safe4i.usf.core.usfmodel.common.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.safe4i.usf.core.usfmodel.block.BlocksFactory;
import org.safe4i.usf.core.usfmodel.common.CommonsFactory;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowsFactory;
import org.safe4i.usf.core.usfmodel.errorHandling.ErrorHandlingFactory;
import org.safe4i.usf.core.usfmodel.util.LabelProviderHelper;

/**
 * This is the item provider adapter for a {@link org.safe4i.usf.core.usfmodel.common.Package} object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PackageItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageItemProvider(AdapterFactory adapterFactory) {
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
			addNamePropertyDescriptor(object);
			addDocumentationPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_NamedElement_name_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
				CommonsPackage.Literals.NAMED_ELEMENT__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(CommonsPackage.Literals.MODEL__CONTENT);
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
	 * This returns Package.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Package"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((org.safe4i.usf.core.usfmodel.common.Package) object).getName();
		if (label == null || label.isEmpty()) {
			label = LabelProviderHelper.NO_NAME_LITERAL;
		}
		final org.safe4i.usf.core.usfmodel.common.Package element = (org.safe4i.usf.core.usfmodel.common.Package) object;
		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(element.eClass().getName());

		return "[" + eClassName + "] " + label;
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

		switch (notification.getFeatureID(org.safe4i.usf.core.usfmodel.common.Package.class)) {
		case CommonsPackage.PACKAGE__UNIQUE_IDENTIFIER:
		case CommonsPackage.PACKAGE__NAME:
		case CommonsPackage.PACKAGE__DOCUMENTATION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case CommonsPackage.PACKAGE__CONTENT:
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

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, CommonsFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, CommonsFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, CommonsFactory.eINSTANCE.createArrayType()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, CommonsFactory.eINSTANCE.createStructType()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, CommonsFactory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, BlocksFactory.eINSTANCE.createBlockType()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ErrorHandlingFactory.eINSTANCE.createErrorHandler()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ControlFlowsFactory.eINSTANCE.createDecisionNode()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ControlFlowsFactory.eINSTANCE.createMergeNode()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ControlFlowsFactory.eINSTANCE.createForkNode()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ControlFlowsFactory.eINSTANCE.createJoinNode()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ControlFlowsFactory.eINSTANCE.createSendSignalNode()));

		newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ControlFlowsFactory.eINSTANCE.createReceiveSignalNode()));
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
