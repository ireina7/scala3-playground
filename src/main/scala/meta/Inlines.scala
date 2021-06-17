package playground.meta


/**
 * A basic example
*/
object Config:
  inline val logging = false

object Logger:

  private var indent = 0

  inline def log[T](msg: String, indentMargin: =>Int)(op: => T): T =
    if Config.logging then // this will be unfolded and only the false-branch `op` will left
      println(s"${"  " * indent}start $msg")
      indent += indentMargin
      val result = op
      indent -= indentMargin
      println(s"${"  " * indent}$msg = $result")
      result
    else op
end Logger



/**
 * Recursive Inline Methods
*/
inline def power(x: Double, n: Int): Double =
  if n == 0 then 1.0
  else if n == 1 then x
  else
    val y = power(x, n / 2)
    if n % 2 == 0 then y * y else y * y * x
end power

def testRecursiveInlines() = 
  val i = 2
  val x = power(i, 10)
  println(s"power(2, 10) => $x")



/**
 * Transparent inlines
*/
class A
class B extends A:
  def m = true

transparent inline def chooseT(b: Boolean): A =
  if b then new A else new B

inline def choose(b: Boolean): A =
  if b then new A else new B

def receiveOnlyB(b: B) = {}
def testTransparent() = 
  receiveOnlyB(chooseT(false))
  //receiveOnlyB(choose(false)) //This will compile error



trait Logger:
  def log(x: Any): Unit

class PrintLogger extends Logger:
  inline def log(x: Any): Unit = {
    //assert(1 == 0)
    println(x)
  }

trait InlineLogger:
  inline def log(inline x: Any): Unit

class PrintInlineLogger extends InlineLogger:
  inline def log(inline x: Any): Unit = println(x)


  


object Inlines extends playground.Test("Inlines") {
  override def test(): Unit = {
    testRecursiveInlines()
    testTransparent()

    val printLogger: PrintLogger = PrintLogger()
    val logger: Logger = PrintLogger()
    logger.log("This is not inlined at compile time")
    printLogger.log("ok, I'm inlined at compile time")

    val inlineLogger: PrintInlineLogger = PrintInlineLogger()
    inlineLogger.log("ok")
  }
}
