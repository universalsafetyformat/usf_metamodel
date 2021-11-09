# Changelog of the metamodel

Inital version is v0.8.0

## v0.8.0

- Added Annonations
- Changed nsURI to "https://www.universalsafetyformat.org/XYZ"
- Added BlockType Stereotypes/Parameter
- Renaming:

| v0.7.2                                                             | v0.8.0                                                         |
|--------------------------------------------------------------------|----------------------------------------------------------------|
| controlflow                                                        | controlFlow                                                    |
| controlflow::ErrorControlFlowPort                                  | errorHandling::ErrorControlFlowPort                            |
| controlflow::SignalNode::errorControlFlowPort                      | controlFlow::SignalNode::controlFlowPort                       |
| common::PatternConfiguration                                       | -                                                              |
| annotation::SafetyMeasureParameter::parameterName                  | annotation::SafetyMeasureParameter::name                       |
| annotation::SafetyMeasure::safetyMeasureAssignments                | annotation::SafetyMeasure::assignments                         |
| block::DataPort                                                    | block::DataFlowPort                                            |
| block::BlockType::ownedBlock                                       | block::BlockType::blocks                                       |
| block::BlockType::ownedDataPort                                    | block::BlockType::dataFlowPorts                                |
| block::BlockType::ownedConnection                                  | block::BlockType::dataFlowConnections                          |
| block::DataFlowConnection::connectionEnd1                          | block::DataFlowConnection::sourcePort                          |
| block::DataFlowConnection::connectionEnd2                          | block::DataFlowConnection::destinationPort                     |
| block::AssemblyDataFlowConnection::contextBlock1                   | block::AssemblyDataFlowConnection::sourceBlock                 |
| block::AssemblyDataFlowConnection::contextBlock2                   | block::AssemblyDataFlowConnection::destinationBlock            |
| block::AssemblyConnection                                          | block::AssemblyDataFlowConnection                              |
| block::DelegateConnection                                          | block::DelegateDataFlowConnection                              |
| common::ArrayType::lenght                                          | common::ArrayType::length                                      |
| controlflow::ControlFlowAwareBlockType::ownedControlFlowPort       | controlFlow::ControlFlowAwareBlockType::controlFlowPorts       |
| controlflow::ControlFlowAwareBlockType::ownedControlFlowConnection | controlFlow::ControlFlowAwareBlockType::controlFlowConnections |
| controlflow::ControlFlowConnection::connectionEnd1                 | controlFlow::ControlFlowConnection::sourcePort                 |
| controlflow::ControlFlowConnection::connectionEnd2                 | controlFlow::ControlFlowConnection::destinationPort            |
| controlflow::SignalNode::hw_channel                                | Deleted - Use parameter or stereotype instead                  |
| dataPortTemplate                                                   | portTemplate                                                   |
| errorHandling::ErrorPort                                           | errorHandling::ErrorDataPort                                   |
