package playground


def runTests() = 

  import types.*
  import context.*
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
    DependentPathType,
    OpaqueTypes,

    //===== Contextual abstraction =====//
    Conversions,
    KotlinSimulation,

    //===== Meta programming =====//
    Inlines,
    CompileTimeOps,
    TestMacros,

    //===== Syntax =====//
    NewSyntax,

    //===== Miscs =====//
    UniversalApply,
    //Exports,
    ExtensionMethod,
    AutoParamTupling,
    MultiversalEquality,
    PatternMatching,
    Wildcards,
  
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

