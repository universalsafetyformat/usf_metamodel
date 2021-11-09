/**
 * Copyright (c) 2021 itemis AG (www.itemis.com), FZI Forschungszentrum Informatik (www.fzi.de),
 * ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */

package org.safe4i.usf.core.tests

import org.junit.BeforeClass
import org.junit.Test
import org.safe4i.usf.core.USFModelRuntime
import org.safe4i.usf.core.usfmodel.block.BlockType
import org.safe4i.usf.core.usfmodel.common.Model

import static org.junit.Assert.assertTrue
import static org.safe4i.usf.core.tests.USFTestUtil.*

import static extension org.safe4i.usf.core.util.USFModelExtensions.*
import org.safe4i.usf.core.usfmodel.block.PortDirection

class SaveUSFBlockModelTest {
	@BeforeClass
	def static void init() {
		// register infrastructure
		USFModelRuntime.init()
	}

	// TODO: extract common TestBase class
	// TODO: add special tests for testing validation rules

	@Test
	def void testSaveAndLoadModel01() {
		{
			val model = commonFactory.createModel

			val system = model.createBlockType("System")

			val intType = commonFactory.createPrimitiveType => [
				name = "int"
			]
			model.content.add(intType)

			val src = model.createBlockAndType("Source")
			val port1 = blockFactory.createDataFlowPort => [
				name = "Out"
				direction = PortDirection.OUT
				type = intType
			]
			src.key.dataFlowPorts.add(port1)
			system.blocks.add(src.value)

			// src2 is second instance of BlockType "Source", it won't be connected
			val src2 = createBlock(src.key, "source2")
			system.blocks.add(src2)

			val sink = model.createBlockAndType("Sink")
			val port3 = blockFactory.createDataFlowPort => [
				name = "In"
				direction = PortDirection.IN
				type = intType
			]
			sink.key.dataFlowPorts.add(port3)
			system.blocks.add(sink.value)

			// build connection
			val conn = blockFactory.createAssemblyDataFlowConnection => [
				sourceBlock = src.value
				sourcePort = port1
				destinationBlock = sink.value
				destinationPort = port3
			]
			system.dataFlowConnections.add(conn)

			saveModel(model, "model-gen/Model0.xmi")
		}

		{
			val model = loadModel("model-gen/Model0.xmi")

			assertTrue(!hasErrors(model))
			assertTrue(model instanceof Model)
			for(BlockType blockType : (model as Model).content.filter(typeof(BlockType))) {
				System.out.println('''BlockType «blockType.name»''') 
			}
		}
	}

}
