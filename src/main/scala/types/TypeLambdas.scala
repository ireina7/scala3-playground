package playground.types


/**
  * Type Lambdas: https://dotty.epfl.ch/docs/reference/new-types/type-lambdas.html
  */
object TypeLambdas extends playground.Test("TypeLambdas") {

    type T[+X, Y] = Map[Y, X]

    type Tuple = [X] =>> (X, X)

    override def test(): Unit = {

        val m: T[String, Int] = Map(1 -> "1")
        println(m)

        val tuple: Tuple[String] = ("a", "b")
        println(tuple)
    }

}