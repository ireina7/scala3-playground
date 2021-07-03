package playground.meta

import scala.compiletime.{
  constValue, 
  constValueOpt,
  erasedValue,
  error,
}


import scala.compiletime.constValue
import scala.compiletime.ops.int.S

transparent inline def toIntC[N]: Int =
  inline constValue[N] match
    case 0        => 0
    case _: S[n1] => 1 + toIntC[n1]


/**
 * This is truely useful since you can make decisions purely 
 * based on type parameters.
*/
inline def defaultValue[T] =
  inline erasedValue[T] match
    case _: Byte    => Some(0: Byte)
    case _: Char    => Some(0: Char)
    case _: Short   => Some(0: Short)
    case _: Int     => Some(0)
    case _: Long    => Some(0L)
    case _: Float   => Some(0.0f)
    case _: Double  => Some(0.0d)
    case _: Boolean => Some(false)
    case _: Unit    => Some(())
    case _          => None

def testConstValue() = 
  inline val ctwo = toIntC[2]
  println(ctwo)
  println(constValue[1])
  //println(erasedValue[Int]) //compile error!
  println(defaultValue[Int]) // It works!




inline def fail(p1: => Any) =
  error("failed on: $p1")


/**
 * Singleton types
*/
import scala.compiletime.ops.int.*
import scala.compiletime.ops.boolean.*

val conjunction: true && true = true
val multiplication: 3 * 5 = 15



/**
 * Implicit selection
*/
import scala.compiletime.summonFrom

object CompileTimeOps extends playground.Test("Compile time operations") {
  override def test(): Unit = {
    //fail("error")
    testConstValue()
  }
}