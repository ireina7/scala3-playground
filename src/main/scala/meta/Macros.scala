package playground.meta

import scala.quoted.*


def playWithExpr(e: Expr[Int])(using Quotes) = 
  val expr: Expr[Int] = '{ 1 }
  //println(expr)
end playWithExpr


inline def eval(inline e: Int): Int = ${ evalExpr('e) }

private def evalExpr(e: Expr[Int])(using Quotes): Expr[Int] = e match
  case '{ val y: Int = $x; $body(y): Int } =>
    evalExpr(Expr.betaReduce('{$body(${evalExpr(x)})}))
  case '{ ($x: Int) * ($y: Int) } =>
    (x.value, y.value) match
      case (Some(a), Some(b)) => Expr(a * b)
      case _ => e
  case _ => e





object Macros extends playground.Test("Macros") {

  override def test() = {
    //playWithExpr('{ 1 })
    Debug.debugSingle({
      val x = 3
      x * 7
    })
  }
}