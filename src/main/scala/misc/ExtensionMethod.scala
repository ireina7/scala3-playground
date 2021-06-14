package playground.misc

object ExtensionMethod extends playground.Test("Extension Method") {

    /**
     * This is a basic example from dotty documentation
     */
    case class Circle(x: Double, y: Double, radius: Double)

    extension (c: Circle)
        def circumference: Double = c.radius * math.Pi * 2

    /**
     * Test if extension methods can contradict existing method
     * After testing, extension methods cannot override existing object methods
     */
     extension (i: Int)
        def +(j: Int): String = "nonono"

    /**
     * Extensions can have generic parameters
     */
     extension [A](xs: List[A])
        def -+>(x: A) = x

    /**
     * Extention collection
     */
     extension (c: Circle)
        def -|====> = "Excalibar"
        def -=>>>>> = "Ice cream"
    
    override def test() = {
        val circle = Circle(0, 1, 1)
        println(circle.circumference)

        println(1 + 2)
        println(List(1, 2, 3) -+> 7)
        println(circle.-|====>)
        println(circle.-=>>>>>)
    }
}