# USF Data Model Project


## Project Overview
This eclipse project contains the definition of the USF Data Model which is located in (`model/*`) as well as some helper classes.


## Core Concepts

The USF Metamodel consists of several concepts which are outlined below. 

### Common Base Classes
<img src="doc/Common Baseclass.png" width="512">

The content of the USF Metamodel can be stored inside a Model which servs as top-level entry point. Further structuring of the contained data can be achieved by using Packages. Elements contained by the Model or Package are classified as IModelContent. 

Additional to this, two types (DocumentedElement and NamedElement) are used to classify types in the USF Metamodel which have a name and/or a documentation. 

### Type Concepts
<img src="doc/Common Type Concept.png" width="1024">

The type concept is used to represent structs, arrays, enumerations, and primitive types. It is used to type Data Ports to further describe the structure of the information transferred via that port. Additional to this it is used in the Parameter concept to define additional values required for the USF model elements.


### Block, Port and Connection Concepts
<img src="doc/Block Port and Connection Concept.png" width="1024">

To represent a system structure or information flow, the concepts of Blocks, Ports, and Connections are used (see also Control Flow Concepts).

Elements of a system are modeled as `Block`s and are characterized by a `BlockType`. Information flow between `Blocks` are mapped as `DataFlowPort`s connected via `DataFlowConnection`. `DataFlowPort`s can be typed with `Type`s of the USF Type Concepts. The direction of the data flow is specified by the ` PortDirection`.

### Control Flow Concepts
<img src="doc/Control Flow Concept.png" width="1024">

For the modeling of information flow special port and connection concepts are provided in USF. This scopes the focus to separate information- and control flow modeling.

Derived concepts are explicitly focused on control flow. To represent control flow `ControlFlowPort`s and `ControlFlowConnection`s are used. Additional dedicated Blocktypes for Join, Fork, Merge and Decision are provided to model the control flow. Send and Receive Signal are used to start or consume a control flow and will consume ore emit a defined signal in the system.


### Error Handling Concepts
<img src="doc/Error Handling Concept.png" width="1024">

Error Handling is derived from the Block Concepts (like the ControlFlow Concept) to scope the focus on error handling. `ErrorHandler` is a subtype of `BlockType` and can be used in the system context. `ErrorDataPort` and `ErrorControlFlowPort` are specific data and control flow ports used in the context of error handling.


### Stereotype and Parameter Concepts

<img src="doc/Parameter and Sterotype Concept.png" width="1024">

The concept will be used to parameterize safety measures it can be used to add Parameters directly to `BlockType`s, `Block`s, `Port`s, and `Connection`s as well as define Saftety Measure inputs during Safety Pattern definition (see also Safety Measure Concept).


#### Stereotype Concepts
`Stereotype`s are a concept to categorize/classify a set of elements which share the same characteristics. It is decoupled from the BlockType concept which is limited to Blocks only. Stereotypes can be added to model elements via `StereotypeAssignment`.

The Stereotype concept can also be used to define Parameters by `ParameterDefinition`. They specify a set of properties which should be added together with a Stereotype. For example, a Stereotype “Task” should always have a “timeout_in_ms” Parameter which needs to be specified if the Stereotype is assigned to an element. Which Parameters should be set if a Stereotype is assigned can be specified via `Stereotype::parameters` and the values are specified in `StereotypeAssignment::values` (`SterotypeAssignment::values::parameter` has to be a subset of `Stereotype::parameters`).

#### Parameter Concepts
A `ParameterDefinition` represents a dedicated parameter which is used by the transformation to introduce safety measures. For example *timeout_in_ms*, *upper_bound*, *lower_bound*, ... The Parameters (`ParameterDefinition`) can be defined in the Model and grouped via  Stereotype (see above) if needed. 

`ParameterValue`s are used to specify a concrete value for a given `ParameterDefinition` which is also stored as part of the `StereotypeAssignment` (if the `ParameterDefinition` is declare as part of a Stereotype) or `ParameterAssignment` if the Parameter should be just set without the use of a Stereotype. The Parameters will also be used by the definition of the Safety Pattern to provide the interface definition for the safety transformation.

For each Parameter `ParameterValue`s can be defined which store the concrete values of the Parameter for a certain element or safety measure.


### Safety Measure Concept
<img src="doc/Safety Measure concept.png" width="1024">

A Safety Measure is a concrete, optional parameterized, mechanism, which should be weaved (model-to-model transformation or model-to-code transformation) into a final model or final code.

It is divided into `SafetyPattern` and `SafetyPatternApplication`. A `SafetyPattern` specifies an interface of a Safety Pattern. To assign a Safety Pattern a `SafetyPatternApplication` is created which has the corresponding `SafetyPattern` which defines the Safety Pattern. The `SafetyPatternApplication` will then contain the dedicated values which can for example be simple strings or model elements to configure the transformation which will perform the safety measure on the domain model.