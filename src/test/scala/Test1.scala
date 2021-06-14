package playground.test

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.flatspec.AnyFlatSpec


class SimpleTest extends AnyFlatSpec:

  "All tests" should "run fluently" in {
    playground.runTests()
    assert(true)
  }
  //test("test with Int.MaxValue") (pending)
end SimpleTest



/*
import org.junit.Test
import org.junit.Assert.*

class Test1:
  @Test def t1(): Unit = 
    assertEquals("I was compiled by Scala 3. :)", "")
*/