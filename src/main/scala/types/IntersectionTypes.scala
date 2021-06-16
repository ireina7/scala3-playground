package playground.types


/**
  * Intersection Types: https://dotty.epfl.ch/docs/reference/new-types/intersection-types.html
  */
object IntersectionTypes extends playground.Test("Intersection types") {

    sealed trait X {
        def x: Double
        def tpe: X
    }

    sealed trait Y {
        def y: Double
        def tpe: Y
    }

    type P = Y & X
    type PP = X & Y

    final case class Point(x: Double, y: Double) extends X with Y {
        override def tpe: X & Y = ???
    }


    trait Animal {
        def talk: String
    }
    trait Cat extends Animal {
        override def talk: String = "Meow"
    }
    trait Dog extends Animal {
        override def talk: String = "Woof"
    }

    class KittyDog extends Cat, Dog {
        //override def talk: String = "MW"
    }

    override def test(): Unit = {

        def euclideanDistance(p1: X & Y, p2: X & Y) = {
            Math.sqrt(Math.pow(p2.y - p1.y, 2) + Math.pow(p2.x - p1.x, 2))
        }
        val p1: P = Point(3, 4)
        val p2: PP = Point(6, 8)
        println(euclideanDistance(p1, p2))

        // Still support mixin
        val kittydoggy = new Cat with Dog
        val doggykitty = new Dog with Cat
        val hybrid = new KittyDog
        println(s"new Cat with Dog: ${kittydoggy.talk}")
        println(s"new Dog with Cat: ${doggykitty.talk}")
        println(s"KittyDog: ${hybrid.talk}")
    }
}