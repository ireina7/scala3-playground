package playground.misc


object Wildcards extends playground.Test("Wildcards in types"):

  /**
   * In the future, 
   * F[_] only stands for [X] =>> F[X]
   * F[?] stands for F[A] forSome A (although this is not existential type! (actually refined type))
  */
  override def test(): Unit = {

    def testWith_?(xs: List[?]): Int = xs.length
    println(testWith_?("123456789".toList))

    //def testWith__(xs: List[_]): Int = xs.length // This will be phased out in the future
  }
end Wildcards