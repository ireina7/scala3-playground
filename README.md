## My personal playground of Scala3!

![Scala3](./img/scala3-icon.png)

### Feature list
#### Types
- [Enum types](./src/main/scala/types/EnumTypes.scala)
- [Intersection types](./src/main/scala/types/IntersectionTypes.scala)
- [Union types](./src/main/scala/types/UnionTypes.scala)
- [Structural types](./src/main/scala/types/StructuralTypes.scala)
- [Typeclasses](./src/main/scala/types/Typeclasses.scala)
- [Type lambdas](./src/main/scala/types/TypeLambdas.scala)
- [Dependent Path Type](./src/main/scala/types/DependentPathType.scala)
- [Opaque types](./src/main/scala/types/OpaqueTypes.scala)

#### Meta programming
- [Inlines](./src/main/scala/meta/Inlines.scala)
- [Compile time operations](./src/main/scala/meta/CompileTimeOps.scala)
- [Macros](./src/main/scala/meta/Macros.scala)

#### Syntax
- [New syntax](./src/main/scala/syntax/NewSyntax.scala)

#### Miscellaneous
- [Universal apply methods](./src/main/scala/misc/UniversalApply.scala)
- [Export clauses](./src/main/scala/misc/Exports.scala)
- [Extension methods](./src/main/scala/misc/ExtensionMethod.scala)
- [Auto Parameter Tupling](./src/main/scala/misc/AutoParamTupling.scala)
- [Multiversal Equality](./src/main/scala/misc/MultiversalEquality.scala)
- [Pattern Matching](./src/main/scala/misc/PatternMatching.scala)
- [Wildcards](./src/main/scala/misc/Wildcards.scala)


### Usage
This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).
