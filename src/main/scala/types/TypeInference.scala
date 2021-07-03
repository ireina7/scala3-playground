package playground.types


object TypeInference extends playground.Test("Type inference"):

  override def test(): Unit = {
    def test0[A, B](a: A, f: A => B): B = f(a)
    def test1[A, B](a: A)(f: A => B): B = f(a)

    test0(0, _ + 1) // not work in Scala2
    test1(0)(_ + 1) // work in Scala2 and Scala3
  }

end TypeInference