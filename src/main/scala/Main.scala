package playground


import types.*

@main def hello: Unit =
  println("Hello Scala3!")

  List(
    IntersectionTypes,
    UnionTypes,
    Typeclasses,
    EnumTypes,
    StructuralTypes,
    TypeLambdas,
  
  ).zipWithIndex.foreach { (feature, i) =>
    println(s"\n>> Testing ${feature.name}")
    feature.test()
  }

end hello

