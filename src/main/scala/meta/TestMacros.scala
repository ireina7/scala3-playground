package playground.meta

//import 


object TestMacros extends playground.Test("Macros") {

  
  override def test() = {
    import scala.quoted.*
    
    //playWithExpr('{ 1 })
    Debug.debugSingle({
      val x = 3
      x * 7
    })

    val x = 1
    Macros.assert(x != 0)
    Macros.testQuotes()
  }
}