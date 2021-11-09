/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.core.util

import org.eclipse.emf.ecore.EObject
import org.safe4i.usf.core.usfmodel.block.Block
import org.safe4i.usf.core.usfmodel.block.BlockType
import org.safe4i.usf.core.usfmodel.block.BlocksFactory
import org.safe4i.usf.core.usfmodel.block.BlocksPackage
import org.safe4i.usf.core.usfmodel.common.CommonsFactory
import org.safe4i.usf.core.usfmodel.common.CommonsPackage
import org.safe4i.usf.core.usfmodel.common.Model

/**
 * Utility extensions for handling the USF metamodel.
 * 
 * @author Klaus Birken (itemis AG) 
 */
class USFModelExtensions {
	
	public static BlocksPackage USF_BLOCK_PACKAGE = BlocksPackage.eINSTANCE
	public static CommonsPackage USF_COMMON_PACKAGE = CommonsPackage.eINSTANCE

	// TODO remove. This is just an example for a typical utility method which might be found here. 
	def static getContextBlock(EObject child) {
		var i = child.eContainer
		while (i !== null) {
			if (i instanceof Block) {
				return i
			}
			i = i.eContainer
		}
		return null
	}
	
	def static blockFactory() {
		BlocksFactory.eINSTANCE
	}
	
	def static commonFactory() {
		CommonsFactory.eINSTANCE
	}

	def static createBlockType(String name0) {
		USFModelExtensions.blockFactory.createBlockType() => [
			name = name0
		]
	}

	def static createBlockType(Model model, String name0) {
		val bt = createBlockType(name0)
		model.content.add(bt)
		bt
	}

	def static createBlock(BlockType type0, String name0) {
		USFModelExtensions.blockFactory.createBlock() => [
			type = type0
			name = name0
		]
	}

	def static Pair<BlockType, Block> createBlockAndType(String name0) {
		val bt = createBlockType(name0)
		val b = createBlock(bt, name0.toFirstLower)
		bt -> b
	}

	def static Pair<BlockType, Block> createBlockAndType(Model model, String name0) {
		val bat = createBlockAndType(name0)
		model.content.add(bat.key)
		bat
	}
}
