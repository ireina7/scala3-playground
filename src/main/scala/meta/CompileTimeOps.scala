package playground.meta

import scala.compiletime.{
  constValue, 
  constValueOpt,
  erasedValue,
  error,
}


inline def fail(p1: => Any) =
  error(s"failed on: $p1")


/**
 * Singleton types
*/
import scala.compiletime.ops.int.*
import scala.compiletime.ops.boolean.*

val conjunction: true && true = true
val multiplication: 3 * 5 = 15






object CompileTimeOps extends playground.Test("Compile time operations") {
  override def test(): Unit = {
    //
  }
}