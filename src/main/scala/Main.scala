package playground


def runTests() = 

  import types.*
  import meta.*
  import syntax.*
  import misc.*
  List(
    //===== Types =====//
    IntersectionTypes,
    UnionTypes,
    Typeclasses,
    EnumTypes,
    StructuralTypes,
    TypeLambdas,
    OpaqueTypes,

    //===== Meta programming =====//
    Inlines,
    CompileTimeOps,
    Macros,

    //===== Syntax =====//
    NewSyntax,

    //===== Miscs =====//
    UniversalApply,
    Exports,
  
  ).zipWithIndex.foreach { (feature, i) =>
    println(s"\n>> Testing ${feature.name}")
    feature.test()
  }
end runTests



@main def hello: Unit =
  println("Hello Scala3!")
  println("> Running Scala3 features...")
  runTests()

end hello

