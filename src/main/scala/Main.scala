package playground


import types.*

@main def hello: Unit =
  println("Hello Scala3!")

  List(
    IntersectionTypes,
    UnionTypes,
    Typeclasses,
  
  ) foreach { feature =>
    println(s"\n>> Testing ${feature.name}")
    feature.test()
  }

end hello

