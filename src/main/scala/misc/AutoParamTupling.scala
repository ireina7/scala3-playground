package playground.misc

/**
  * Automatic Tupling of Function Params: https://dotty.epfl.ch/docs/reference/other-new-features/auto-parameter-tupling.html
  */
object AutoParamTupling extends playground.Test("Auto Parameter Tupling") {

    override def test(): Unit = {

        /**
          * In order to get thread safety, you need to put @volatile before lazy vals.
          * https://dotty.epfl.ch/docs/reference/changed-features/lazy-vals.html
          */
        @volatile lazy val xs: List[String] = List("d", "o", "t", "t", "y")

        /**
          * Current behaviour in Scala 2.12.2 :
          * error: missing parameter type
          * Note: The expected type requires a one-argument function accepting a 2-Tuple.
          * Consider a pattern matching anonymous function, `{ case (s, i) =>  ... }`
          */
        xs.zipWithIndex.map((s, i) => println(s"$i: $s"))      //Scala3
        xs.zipWithIndex.map{case (s, i) => println(s"$i: $s")} //Scala2
    }
}