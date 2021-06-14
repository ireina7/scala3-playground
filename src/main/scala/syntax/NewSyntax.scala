package playground.syntax


object NewSyntax extends playground.Test("NewSyntax"):
    def newIfSyntax = 
        if 1 == 0 then "1 == 0" else "1 != 0"
    
    def newMultiIfSyntax = 
        if 1 == 0 then
            "1 == 0"
        else if 1 == 2 then
            "1 == 2"
        else "nothing"

    def newMatchingSyntax(x: Int) = 
        x match
            case 1 => "one"
            case 0 => "zero"
            case _ => "num"
    end newMatchingSyntax

    /**
     * A very bad example
     */
    abstract class C():

        def this(x: Int) =
            this()
            if x > 0 then
                val a :: b =
                    x :: Nil
                end val
                var y =
                    x
                end y
                while y > 0 do
                    println(y)
                    y -= 1
                end while
                try
                    x match
                        case 0 => println("0")
                        case _ => ???
                    end match
                finally
                    println("done")
                end try
            end if
        end this

        def f: String
    end C

    object C:
        given C =
            new C:
                def f = "!"
                end f
            end new
        end given
    end C

    extension (x: C)
        def ff: String = x.f ++ x.f
    end extension


    override def test() = {
        println(newIfSyntax)
        println(newMultiIfSyntax)
        println(newMatchingSyntax(7))

        /* 
        //These are only experimental features
        import language.experimental.fewerBraces
        val xs = List(1, 2, 3)
        xs.map:
            x =>
                val y = x - 1
                y * y
        println(ys)
        */
        
    }

end NewSyntax