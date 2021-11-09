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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.safe4i.usf.core.usfmodel.USFEditPlugin;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.common.util.CommonsSwitch;
import org.safe4i.usf.core.usfmodel.parameter.ParametersFactory;
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage;
import org.safe4i.usf.core.usfmodel.parameter.util.ParametersAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this factory convert EMF adapter
 * notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters also support Eclipse property sheets. Note that most of the adapters
 * are shared among multiple instances. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ParametersItemProviderAdapterFactory extends ParametersAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(USFEditPlugin.INSTANCE, ParametersPackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<>();

	/**
	 * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParametersItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.Stereotype} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected StereotypeItemProvider stereotypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.Stereotype}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createStereotypeAdapter() {
		if (stereotypeItemProvider == null) {
			stereotypeItemProvider = new StereotypeItemProvider(this);
		}

		return stereotypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockStereotypeAssignment} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockStereotypeAssignmentItemProvider blockStereotypeAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockStereotypeAssignment}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockStereotypeAssignmentAdapter() {
		if (blockStereotypeAssignmentItemProvider == null) {
			blockStereotypeAssignmentItemProvider = new BlockStereotypeAssignmentItemProvider(this);
		}

		return blockStereotypeAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeStereotypeAssignment} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockTypeStereotypeAssignmentItemProvider blockTypeStereotypeAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeStereotypeAssignment}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockTypeStereotypeAssignmentAdapter() {
		if (blockTypeStereotypeAssignmentItemProvider == null) {
			blockTypeStereotypeAssignmentItemProvider = new BlockTypeStereotypeAssignmentItemProvider(this);
		}

		return blockTypeStereotypeAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.PortStereotypeAssignment} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PortStereotypeAssignmentItemProvider portStereotypeAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.PortStereotypeAssignment}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPortStereotypeAssignmentAdapter() {
		if (portStereotypeAssignmentItemProvider == null) {
			portStereotypeAssignmentItemProvider = new PortStereotypeAssignmentItemProvider(this);
		}

		return portStereotypeAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionStereotypeAssignment} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConnectionStereotypeAssignmentItemProvider connectionStereotypeAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionStereotypeAssignment}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createConnectionStereotypeAssignmentAdapter() {
		if (connectionStereotypeAssignmentItemProvider == null) {
			connectionStereotypeAssignmentItemProvider = new ConnectionStereotypeAssignmentItemProvider(this);
		}

		return connectionStereotypeAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockParameterAssignment} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockParameterAssignmentItemProvider blockParameterAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockParameterAssignment}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockParameterAssignmentAdapter() {
		if (blockParameterAssignmentItemProvider == null) {
			blockParameterAssignmentItemProvider = new BlockParameterAssignmentItemProvider(this);
		}

		return blockParameterAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterAssignment} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockTypeParameterAssignmentItemProvider blockTypeParameterAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterAssignment}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockTypeParameterAssignmentAdapter() {
		if (blockTypeParameterAssignmentItemProvider == null) {
			blockTypeParameterAssignmentItemProvider = new BlockTypeParameterAssignmentItemProvider(this);
		}

		return blockTypeParameterAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.PortParameterAssignment} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PortParameterAssignmentItemProvider portParameterAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.PortParameterAssignment}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPortParameterAssignmentAdapter() {
		if (portParameterAssignmentItemProvider == null) {
			portParameterAssignmentItemProvider = new PortParameterAssignmentItemProvider(this);
		}

		return portParameterAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterAssignment} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConnectionParameterAssignmentItemProvider connectionParameterAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterAssignment}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createConnectionParameterAssignmentAdapter() {
		if (connectionParameterAssignmentItemProvider == null) {
			connectionParameterAssignmentItemProvider = new ConnectionParameterAssignmentItemProvider(this);
		}

		return connectionParameterAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockParameterDefinition} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockParameterDefinitionItemProvider blockParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockParameterDefinitionAdapter() {
		if (blockParameterDefinitionItemProvider == null) {
			blockParameterDefinitionItemProvider = new BlockParameterDefinitionItemProvider(this);
		}

		return blockParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.PortParameterDefinition} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PortParameterDefinitionItemProvider portParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.PortParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPortParameterDefinitionAdapter() {
		if (portParameterDefinitionItemProvider == null) {
			portParameterDefinitionItemProvider = new PortParameterDefinitionItemProvider(this);
		}

		return portParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterDefinition} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockTypeParameterDefinitionItemProvider blockTypeParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockTypeParameterDefinitionAdapter() {
		if (blockTypeParameterDefinitionItemProvider == null) {
			blockTypeParameterDefinitionItemProvider = new BlockTypeParameterDefinitionItemProvider(this);
		}

		return blockTypeParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterDefinition} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConnectionParameterDefinitionItemProvider connectionParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createConnectionParameterDefinitionAdapter() {
		if (connectionParameterDefinitionItemProvider == null) {
			connectionParameterDefinitionItemProvider = new ConnectionParameterDefinitionItemProvider(this);
		}

		return connectionParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterDefinition} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PrimitiveParameterDefinitionItemProvider primitiveParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPrimitiveParameterDefinitionAdapter() {
		if (primitiveParameterDefinitionItemProvider == null) {
			primitiveParameterDefinitionItemProvider = new PrimitiveParameterDefinitionItemProvider(this);
		}

		return primitiveParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.ArrayParameterDefinition} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ArrayParameterDefinitionItemProvider arrayParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.ArrayParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createArrayParameterDefinitionAdapter() {
		if (arrayParameterDefinitionItemProvider == null) {
			arrayParameterDefinitionItemProvider = new ArrayParameterDefinitionItemProvider(this);
		}

		return arrayParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.EnumerationParameterDefinition} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EnumerationParameterDefinitionItemProvider enumerationParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.EnumerationParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createEnumerationParameterDefinitionAdapter() {
		if (enumerationParameterDefinitionItemProvider == null) {
			enumerationParameterDefinitionItemProvider = new EnumerationParameterDefinitionItemProvider(this);
		}

		return enumerationParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PrimitiveParameterValueItemProvider primitiveParameterValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPrimitiveParameterValueAdapter() {
		if (primitiveParameterValueItemProvider == null) {
			primitiveParameterValueItemProvider = new PrimitiveParameterValueItemProvider(this);
		}

		return primitiveParameterValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.TransformationTypeParameterDefinition} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TransformationTypeParameterDefinitionItemProvider transformationTypeParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.TransformationTypeParameterDefinition}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTransformationTypeParameterDefinitionAdapter() {
		if (transformationTypeParameterDefinitionItemProvider == null) {
			transformationTypeParameterDefinitionItemProvider = new TransformationTypeParameterDefinitionItemProvider(this);
		}

		return transformationTypeParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterDefinition} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DomainTypeParameterDefinitionItemProvider domainTypeParameterDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterDefinition}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createDomainTypeParameterDefinitionAdapter() {
		if (domainTypeParameterDefinitionItemProvider == null) {
			domainTypeParameterDefinitionItemProvider = new DomainTypeParameterDefinitionItemProvider(this);
		}

		return domainTypeParameterDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.TransformationTypeValue} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TransformationTypeValueItemProvider transformationTypeValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.TransformationTypeValue}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTransformationTypeValueAdapter() {
		if (transformationTypeValueItemProvider == null) {
			transformationTypeValueItemProvider = new TransformationTypeValueItemProvider(this);
		}

		return transformationTypeValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterValue} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DomainTypeParameterValueItemProvider domainTypeParameterValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterValue}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createDomainTypeParameterValueAdapter() {
		if (domainTypeParameterValueItemProvider == null) {
			domainTypeParameterValueItemProvider = new DomainTypeParameterValueItemProvider(this);
		}

		return domainTypeParameterValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockParameterValue} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockParameterValueItemProvider blockParameterValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockParameterValue}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockParameterValueAdapter() {
		if (blockParameterValueItemProvider == null) {
			blockParameterValueItemProvider = new BlockParameterValueItemProvider(this);
		}

		return blockParameterValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterValue} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockTypeParameterValueItemProvider blockTypeParameterValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterValue}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockTypeParameterValueAdapter() {
		if (blockTypeParameterValueItemProvider == null) {
			blockTypeParameterValueItemProvider = new BlockTypeParameterValueItemProvider(this);
		}

		return blockTypeParameterValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.PortParameterValue} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PortParameterValueItemProvider portParameterValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.PortParameterValue}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPortParameterValueAdapter() {
		if (portParameterValueItemProvider == null) {
			portParameterValueItemProvider = new PortParameterValueItemProvider(this);
		}

		return portParameterValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterValue} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConnectionParameterValueItemProvider connectionParameterValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterValue}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createConnectionParameterValueAdapter() {
		if (connectionParameterValueItemProvider == null) {
			connectionParameterValueItemProvider = new ConnectionParameterValueItemProvider(this);
		}

		return connectionParameterValueItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			final Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders() {
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void dispose() {
		if (stereotypeItemProvider != null) {
			stereotypeItemProvider.dispose();
		}
		if (primitiveParameterDefinitionItemProvider != null) {
			primitiveParameterDefinitionItemProvider.dispose();
		}
		if (arrayParameterDefinitionItemProvider != null) {
			arrayParameterDefinitionItemProvider.dispose();
		}
		if (enumerationParameterDefinitionItemProvider != null) {
			enumerationParameterDefinitionItemProvider.dispose();
		}
		if (primitiveParameterValueItemProvider != null) {
			primitiveParameterValueItemProvider.dispose();
		}
		if (blockStereotypeAssignmentItemProvider != null) {
			blockStereotypeAssignmentItemProvider.dispose();
		}
		if (blockTypeStereotypeAssignmentItemProvider != null) {
			blockTypeStereotypeAssignmentItemProvider.dispose();
		}
		if (portStereotypeAssignmentItemProvider != null) {
			portStereotypeAssignmentItemProvider.dispose();
		}
		if (connectionStereotypeAssignmentItemProvider != null) {
			connectionStereotypeAssignmentItemProvider.dispose();
		}
		if (blockParameterAssignmentItemProvider != null) {
			blockParameterAssignmentItemProvider.dispose();
		}
		if (blockTypeParameterAssignmentItemProvider != null) {
			blockTypeParameterAssignmentItemProvider.dispose();
		}
		if (portParameterAssignmentItemProvider != null) {
			portParameterAssignmentItemProvider.dispose();
		}
		if (connectionParameterAssignmentItemProvider != null) {
			connectionParameterAssignmentItemProvider.dispose();
		}
		if (transformationTypeParameterDefinitionItemProvider != null) {
			transformationTypeParameterDefinitionItemProvider.dispose();
		}
		if (domainTypeParameterDefinitionItemProvider != null) {
			domainTypeParameterDefinitionItemProvider.dispose();
		}
		if (blockParameterDefinitionItemProvider != null) {
			blockParameterDefinitionItemProvider.dispose();
		}
		if (portParameterDefinitionItemProvider != null) {
			portParameterDefinitionItemProvider.dispose();
		}
		if (blockTypeParameterDefinitionItemProvider != null) {
			blockTypeParameterDefinitionItemProvider.dispose();
		}
		if (connectionParameterDefinitionItemProvider != null) {
			connectionParameterDefinitionItemProvider.dispose();
		}
		if (transformationTypeValueItemProvider != null) {
			transformationTypeValueItemProvider.dispose();
		}
		if (domainTypeParameterValueItemProvider != null) {
			domainTypeParameterValueItemProvider.dispose();
		}
		if (blockParameterValueItemProvider != null) {
			blockParameterValueItemProvider.dispose();
		}
		if (blockTypeParameterValueItemProvider != null) {
			blockTypeParameterValueItemProvider.dispose();
		}
		if (portParameterValueItemProvider != null) {
			portParameterValueItemProvider.dispose();
		}
		if (connectionParameterValueItemProvider != null) {
			connectionParameterValueItemProvider.dispose();
		}
	}

	/**
	 * A child creation extender for the {@link CommonsPackage}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static class CommonsChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		protected static class CreationSwitch extends CommonsSwitch<Object> {
			/**
			 * The child descriptors being populated. <!-- begin-user-doc --> <!-- end-user-doc -->
			 * 
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children. <!-- begin-user-doc --> <!-- end-user-doc -->
			 * 
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain. <!-- begin-user-doc --> <!-- end-user-doc -->
			 * 
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}

			/**
			 * <!-- begin-user-doc --> <!-- end-user-doc -->
			 * 
			 * @generated
			 */
			@Override
			public Object caseModel(Model object) {
				newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createStereotype()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createPrimitiveParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createArrayParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createEnumerationParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createBlockStereotypeAssignment()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createBlockTypeStereotypeAssignment()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createPortStereotypeAssignment()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createConnectionStereotypeAssignment()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createBlockParameterAssignment()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createBlockTypeParameterAssignment()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createPortParameterAssignment()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createConnectionParameterAssignment()));

				newChildDescriptors.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT,
						ParametersFactory.eINSTANCE.createTransformationTypeParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createDomainTypeParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createBlockParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createPortParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createBlockTypeParameterDefinition()));

				newChildDescriptors
						.add(createChildParameter(CommonsPackage.Literals.MODEL__CONTENT, ParametersFactory.eINSTANCE.createConnectionParameterDefinition()));

				return null;
			}

			/**
			 * <!-- begin-user-doc --> <!-- end-user-doc -->
			 * 
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			final ArrayList<Object> result = new ArrayList<>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject) object);
			return result;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator() {
			return USFEditPlugin.INSTANCE;
		}
	}

}