package playground.meta

import scala.quoted.*
//import scala.quoted.staging

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



object Debug:
  import scala.quoted.*

  inline def hello(): Unit = println("Hello, world!")
  
  // -- 
  
  inline def debugSingle(inline expr: Any): Unit = ${debugSingleImpl('expr)} 
  
  private def debugSingleImpl(expr: Expr[Any])(using Quotes): Expr[Unit] =
    '{ println("Value of " + ${Expr(expr.show)} + " is " + $expr) }
  
  // --

  inline def debug(inline exprs: Any*): Unit = ${debugImpl('exprs)}

  private def debugImpl(exprs: Expr[Seq[Any]])(using q: Quotes): Expr[Unit] =
    import q.reflect._

    def showWithValue(e: Expr[_]): Expr[String] = '{${Expr(e.show)} + " = " + $e}
  
    val stringExps: Seq[Expr[String]] = exprs match 
      case Varargs(es) =>
        es.map { e =>
          e.asTerm match {
            case Literal(c: Constant) => Expr(c.value.toString)
            case _ => showWithValue(e)
          }
        }
      case e => List(showWithValue(e))
  
    val concatenatedStringsExp = stringExps.reduceOption((e1, e2) => '{$e1 + ", " + $e2}).getOrElse('{""})
    '{println($concatenatedStringsExp)}



object Macros:

  inline def assert(inline expr: Boolean): Unit =
    ${ assertImpl('expr) }

  def assertImpl(expr: Expr[Boolean])(using Quotes) =
    val failMsg: Expr[String] = Expr("failed assertion: " + expr.show)
    '{ if !($expr) then throw new AssertionError($failMsg) }


  
  def testQuotesImpl()(using Quotes) = {
    val expr = Expr("Hello, compiler!")
    println(expr.show)
    '{ }
  }



  def testStringImpl(s: Expr[String])(using Quotes): Expr[Color] = {
    s.value match
      case Some(ss) => {
        println(s"Transforming $ss...")
        '{ parseStringToColor($s) }
      }
      case _ => {
        println(s.show)
        '{Color.Blue}
      }
  }

  enum Color:
    case Red, Green, Blue
  
  def parseStringToColor(s: String): Color = 
    s match
      case "r" => Color.Red
      case "g" => Color.Green
      case "b" => Color.Blue



  inline def testString(inline s: String) = 
    ${ testStringImpl('s) }

  inline def testQuotes() = 
    ${ testQuotesImpl() }


  
  // This is indeed evil. When calling me, I will shut down the entire `scalac` at compile time
  inline def evil: Unit = ${ evilImpl }
  
  def evilImpl(using Quotes): Expr[Unit] = 
    System.exit(0)
    '{ () }

end Macros