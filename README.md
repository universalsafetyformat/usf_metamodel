# Universal Safety Format (USF) metamodel

These Eclipse plugins contain the USF metamodel as well as additional resources.
The USF metamodel is the foundation of the USF approach.

## Learn more about the USF

To improve the functional safety of a technical system’s software, the common approach today is to manually add code that implements safety mechanisms to existing source code.
The manual addition of safety code
* risks introducing flaws into the functional code of the software (which may lead to physical harm in the worst case),
* increases code complexity,
* significantly prolongs development time, and
* makes the code harder to grasp than the functional code alone

The USF was created to improve this situation. USF formally defines functional safety mechanisms and a language to automatically weave them into system models and source code.
What has been a time consuming, error-prone manual task can now be automated.
The format enables users to pick safety mechanisms from a library (e.g., a dual modular redundancy pattern), and specify the locations in the code where the mechanism should be weaved in.
A USF tool then adds the pattern’s safety code to the existing code automatically.

For further information, visit the [USF Website](www.universalsafetyformat.org).

## Dependencies

This requires the following ingredients:
*  [Eclipse 2020-12 (e.g., Modeling Edition)](https://www.eclipse.org/downloads/packages/release/2020-12/r/eclipse-modeling-tools)
*  [Xcore](https://wiki.eclipse.org/Xcore) (available from 2020-12 P2 Repository)
*  [Xtend](https://www.eclipse.org/xtend/) (available from 2020-12 P2 Repository)

## Content

Currently this repository contains:
*  org.safe4i.usf.core: an Eclipse project which contains the actual metamodel definition (`model/USF.xcore`) and some helper classes
*  org.safe4i.usf.core.tests: an Eclipse project providing some very basic tests
*  an Eclipse target definition to ensure a common set of dependencies
*  a maven/Tycho command-line build
*  some Eclipse projects for creating an Eclipse feature and a P2 repo

## License

This project is licensed under the [Eclipse Public License - v 2.0](./LICENSE).

## Acknowlegment

This project was partially funded by the German Federal Ministry of Education and Research (BMBF) within the project SAFE4I (grant number: 01IS17032).
