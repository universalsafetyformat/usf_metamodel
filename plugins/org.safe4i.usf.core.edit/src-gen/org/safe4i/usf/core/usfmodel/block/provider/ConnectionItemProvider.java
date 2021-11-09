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
import org.safe4i.usf.core.usfmodel.block.AbstractBlockType;
import org.safe4i.usf.core.usfmodel.block.AssemblyDataFlowConnection;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlocksPackage;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.DataFlowPort;
import org.safe4i.usf.core.usfmodel.block.DelegateDataFlowConnection;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.controlFlow.AssemblyControlFlowConnection;
import org.safe4i.usf.core.usfmodel.controlFlow.DelegateControlFlowConnection;
import org.safe4i.usf.core.usfmodel.util.LabelProviderHelper;

/**
 * This is the item provider adapter for a {@link org.safe4i.usf.core.usfmodel.block.Connection} object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConnectionItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConnectionItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> It uses overridden implementations of
	 * {@link #getConnectionSourceDefinition(Object)}, {@link #getConnectionArrowRepresentation()} and {@link #getConnectionDestinationDefinition(Object)} to
	 * assemble a string representation, which describes the passed connection regarding on its actual type
	 * 
	 * An option for a assembly controlflow connection is <code>blockA.funcResult ---> blockB.compute</code> <!-- end-user-doc
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return getConnectionSourceDefinition(object) + getConnectionArrowRepresentation(object) + getConnectionDestinationDefinition(object);
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

		switch (notification.getFeatureID(Connection.class)) {
		case BlocksPackage.CONNECTION__UNIQUE_IDENTIFIER:
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

	/**
	 * creates the first part of a string representation of the passed connection
	 * 
	 * @param connection
	 * @return string representation of the connection source
	 */
	private String getConnectionSourceDefinition(Object connection) {
		if (connection instanceof AssemblyDataFlowConnection) {
			return getConnectionSourceDefinition((AssemblyDataFlowConnection) connection);

		} else if (connection instanceof DelegateDataFlowConnection) {
			return getConnectionSourceDefinition((DelegateDataFlowConnection) connection);

		} else if (connection instanceof AssemblyControlFlowConnection) {
			return getConnectionSourceDefinition((AssemblyControlFlowConnection) connection);

		} else if (connection instanceof DelegateControlFlowConnection) {
			return getConnectionSourceDefinition((DelegateControlFlowConnection) connection);
		}

		return LabelProviderHelper.INVALID_LITERAL;
	}

	private String getConnectionSourceDefinition(AssemblyDataFlowConnection connection) {
		final Block block = connection.getSourceBlock();
		final Port port = connection.getSourcePort();

		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(connection.eClass().getName());
		return "[" + eClassName + "] " + getConnectionEndName(block, port);
	}

	private String getConnectionSourceDefinition(DelegateDataFlowConnection connection) {
		final Block block = connection.getInnerBlock();
		final Port port = connection.getSourcePort();

		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(connection.eClass().getName());
		return "[" + eClassName + "] " + getConnectionEndName(block, port);
	}

	private String getConnectionSourceDefinition(AssemblyControlFlowConnection connection) {
		final Block block = connection.getSourceBlock();
		final Port port = connection.getSourcePort();

		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(connection.eClass().getName());
		return "[" + eClassName + "] " + getConnectionEndName(block, port);
	}

	private String getConnectionSourceDefinition(DelegateControlFlowConnection connection) {
		final Block block = connection.getInnerBlock();
		final Port port = connection.getSourcePort();

		final String eClassName = LabelProviderHelper.INSTANCE.beautifyCamelCaseString(connection.eClass().getName());
		return "[" + eClassName + "] " + getConnectionEndName(block, port);
	}

	private String getConnectionArrowRepresentation(Object connection) {
		if (connection instanceof DelegateDataFlowConnection || connection instanceof AssemblyDataFlowConnection) {
			return " ---- ";
		} else {
			return " ---> ";
		}
	}

	private String getConnectionDestinationDefinition(Object connection) {
		if (connection instanceof AssemblyDataFlowConnection) {
			return getConnectionDestinationDefinition((AssemblyDataFlowConnection) connection);

		} else if (connection instanceof DelegateDataFlowConnection) {
			return getConnectionDestinationDefinition((DelegateDataFlowConnection) connection);

		} else if (connection instanceof AssemblyControlFlowConnection) {
			return getConnectionDestinationDefinition((AssemblyControlFlowConnection) connection);

		} else if (connection instanceof DelegateControlFlowConnection) {
			return getConnectionDestinationDefinition((DelegateControlFlowConnection) connection);
		}

		return LabelProviderHelper.INVALID_LITERAL;
	}

	private String getConnectionDestinationDefinition(AssemblyDataFlowConnection connection) {
		final Block block = connection.getDestinationBlock();
		final Port port = connection.getDestinationPort();

		return getConnectionEndName(block, port);
	}

	private String getConnectionDestinationDefinition(DelegateDataFlowConnection connection) {
		final Port port = connection.getDestinationPort();

		return getConnectionEndName(null, port);
	}

	private String getConnectionDestinationDefinition(AssemblyControlFlowConnection connection) {
		final Block block = connection.getDestinationBlock();
		final Port port = connection.getDestinationPort();

		return getConnectionEndName(block, port);
	}

	private String getConnectionDestinationDefinition(DelegateControlFlowConnection connection) {
		final Port port = connection.getDestinationPort();

		return getConnectionEndName(null, port);
	}

	private String getConnectionEndName(Block block, Port port) {
		if (block != null && port != null) { // AssemblyConnection
			final String blockName = block.getName() == null || block.getName().isEmpty() ? LabelProviderHelper.NO_NAME_LITERAL : block.getName();
			final String portName = port.getName() == null || port.getName().isEmpty() ? LabelProviderHelper.NO_NAME_LITERAL : port.getName();

			return blockName + "." + portName;
		} else if (block == null && port != null) { // DelegateConnection
			final AbstractBlockType blockType = (AbstractBlockType) port.eContainer();
			final String blockTypeName = blockType.getName() == null || blockType.getName().isEmpty() ? LabelProviderHelper.NO_NAME_LITERAL
					: blockType.getName();
			final String portName = port.getName() == null || port.getName().isEmpty() ? LabelProviderHelper.NO_NAME_LITERAL : port.getName();

			if (port instanceof DataFlowPort) {// For data flow ports the name is very likely to be empty -> just dont show it
				if (port.getName() == null || port.getName().isEmpty()) {
					return blockTypeName;
				} else {
					return blockTypeName + "." + portName;
				}
			} else {
				return blockTypeName + "." + portName;
			}

		} else {
			return LabelProviderHelper.INVALID_LITERAL;
		}

	}
}
