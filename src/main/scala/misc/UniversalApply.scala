package playground.misc

class StringEx(s: String):
  def this() = this("")


object UniversalApply extends playground.Test("Universal Apply Methods"):
  override def test() = {
    val abc = StringEx("abc")
    val empty = StringEx()
    println(abc)
  }
end UniversalApply