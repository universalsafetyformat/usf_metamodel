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
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockRelationship;
import org.safe4i.usf.core.usfmodel.block.BlocksPackage;
import org.safe4i.usf.core.usfmodel.block.DeployRelationship;
import org.safe4i.usf.core.usfmodel.block.UseRelationship;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.util.LabelProviderHelper;

/**
 * This is the item provider adapter for a {@link org.safe4i.usf.core.usfmodel.block.BlockRelationship} object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class BlockRelationshipItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BlockRelationshipItemProvider(AdapterFactory adapterFactory) {
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
			addSourcePropertyDescriptor(object);
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
	 * This adds a property descriptor for the Source feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BlockRelationship_source_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_BlockRelationship_source_feature", "_UI_BlockRelationship_type"),
				BlocksPackage.Literals.BLOCK_RELATIONSHIP__SOURCE, true, false, true, null, null, null));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {

		final String fullLabel = "[ " + getRelationShipName(object) + " ] == Source::" + getSource(object) + " ===> " + getTargetName(object)
				+ getTarget(object);
		return fullLabel;
		// final String label = ((BlockRelationship) object).getUniqueIdentifier();
		// return label == null || label.length() == 0 ? getString("_UI_BlockRelationship_type") : getString("_UI_BlockRelationship_type") + " " + label;
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

		switch (notification.getFeatureID(BlockRelationship.class)) {
		case BlocksPackage.BLOCK_RELATIONSHIP__UNIQUE_IDENTIFIER:
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

	private String getRelationShipName(Object object) {
		if (object instanceof UseRelationship) {
			return getRelationShipName((UseRelationship) object);

		} else if (object instanceof DeployRelationship) {
			return getRelationShipName((DeployRelationship) object);

		}

		return LabelProviderHelper.INVALID_LITERAL;
	}

	private String getSource(Object object) {
		if (object instanceof UseRelationship) {
			final Block source = ((UseRelationship) object).getSource();
			return source.getName();

		} else if (object instanceof DeployRelationship) {
			final Block source = ((DeployRelationship) object).getSource();
			return source.getName();
		}

		return LabelProviderHelper.INVALID_LITERAL;
	}

	private String getTarget(Object object) {
		if (object instanceof UseRelationship) {
			final Block source = ((UseRelationship) object).getUses();
			return source.getName();

		} else if (object instanceof DeployRelationship) {
			final Block source = ((DeployRelationship) object).getDeployedAt();
			return source.getName();
		}

		return LabelProviderHelper.INVALID_LITERAL;
	}

	private String getTargetName(Object object) {
		if (object instanceof UseRelationship) {
			return "Uses";
		} else if (object instanceof DeployRelationship) {
			return "DeployedAt";
		}

		return LabelProviderHelper.INVALID_LITERAL;
	}

	private String getRelationShipName(UseRelationship useRelationship) {
		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(useRelationship.eClass().getName());
		return eClassName;
	}

	private String getRelationShipName(DeployRelationship deployRelationship) {
		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(deployRelationship.eClass().getName());
		return eClassName;
	}

}
