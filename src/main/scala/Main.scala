package playground


def runTests() = 
  import types.*
  import meta.*
  List(
    //===== Types =====//
    IntersectionTypes,
    UnionTypes,
    Typeclasses,
    EnumTypes,
    StructuralTypes,
    TypeLambdas,

    //===== Meta programming =====//
    Inlines,
    CompileTimeOps,
  
  ).zipWithIndex.foreach { (feature, i) =>
    println(s"\n>> Testing ${feature.name}")
    feature.test()
  }
end runTests



@main def hello: Unit =
  println("Hello Scala3!")
  println("Running Scala3 features...")
  runTests()

end hello

