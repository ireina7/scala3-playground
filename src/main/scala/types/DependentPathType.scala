package playground.types


object DependentPathType extends playground.Test("Dependent Path Type") {

    trait DPT {
        type T <: Any
        val x: T
    }
    def dpt(x: DPT, y: x.T): x.T = y


    override def test() = {
        val x = new DPT {
            type T = Int
            val x = 7
        }
        val y = new DPT {
            type T = String
            val x = "y"
        }

        //def ft(x: "".type) = x
        val v = 3
        type vt = v.type

        def ff(x: DPT {type T = Int}): x.T = x.x
        println(dpt(x, x.x))
        println(ff(x))
    }
}