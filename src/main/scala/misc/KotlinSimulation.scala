package playground.misc

/**
 * This interesting example is from one of my friend
 * I think this is very interesting although he thinks this is his bad taste:)
 *
 */
object Kotlin {
  class Ctx[T](val x: T) extends AnyVal

  def fun[T, U](fn: Ctx[T] ?=> U)(x: T): U = fn(using new Ctx(x))
  def it[T](using ctx: Ctx[T]) = ctx.x
}

object KotlinSimulation extends playground.Test("Kotlin Simulation") {
    import Kotlin._

    override def test() =
        val res = List(1).map(fun(it + 1))
        assert(res == List(2))
}