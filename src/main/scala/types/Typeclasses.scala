package playground.types


enum Nat:
  case Zero
  case Succ(n: Nat)


extension (n: Nat)
  def isZero = n == Nat.Zero
  def -(m: Nat): Nat =
    import Nat.*
    (n, m) match
      case (Zero, _) => Zero
      case (_, Zero) => n
      case (Succ(n), Succ(m)) => n - m
  end -




enum Ordering:
  case Less, Equal, Great


trait Eq[A]:
  def equal(x: A, y: A): Boolean
  extension (a: A) 
    def ===(b: A) = equal(a, b)
    def =/=(b: A) = !equal(a, b)

trait Ord[A](using ev: Eq[A]):
  export ev.*
  def less(x: A, y: A): Boolean
  extension (a: A)
    def < (b: A) = less(a, b)
    def > (b: A) = !((a == b) || (a < b))
    def <=(b: A) = !(a > b)
    def >=(b: A) = !(a < b)



given Eq[Nat] with
  def equal(x: Nat, y: Nat) = (x, y) match
    case (Nat.Zero, Nat.Zero) => true
    case (Nat.Succ(x), Nat.Succ(y)) => equal(x, y)
    case _ => false


given Ord[Nat] with
  def less(x: Nat, y: Nat) = (x, y) match
    case (Nat.Zero, Nat.Zero) => false
    case (Nat.Zero, _) => true
    case (_, Nat.Zero) => false
    case (Nat.Succ(x), Nat.Succ(y)) => less(x, y)


def less[T: Ord](x: T, y: T) = x < y
def bad[T: Ord](x: T, y: T) = x =/= y

//summon[Ord[Nat]]

trait Functor[F[_]]:
  extension [A](fa: F[A])
    def map[B](f: A => B): F[B]

trait Applicative[F[_]](using ev: Functor[F]):
  export ev.*
  def pure[A](x: A): F[A]
  extension [A](fa: F[A])
    def <*>[B](f: F[A => B]): F[B]


trait Monad[F[_]](using ev: Applicative[F]):
  export ev.*
  extension [A](fa: F[A])
    def flatMap[B](f: A => F[B]): F[B]



given Functor[List] with
  extension [A](fa: List[A])
    def map[B](f: A => B) = for (a <- fa) yield f(a)

given Applicative[List] with
  def pure[A](x: A) = List(x)
  extension [A](fa: List[A])
    def <*>[B](fs: List[A => B]) = for (f <- fs; a <- fa) yield f(a)


given Monad[List] with
  extension [A](fa: List[A])
    def flatMap[B](f: A => List[B]) = fa.flatMap(f)



def testMonad[F[_]: Applicative, A, B](fx: F[A]): F[B] = 
  fx map ???







/**
 * Trying to create the `Default` typeclass
*/
trait Default[T] {
  def default: T
}

object Default {
  def default[T](using ev: Default[T]): T = ev.default
}


given Default[Int] with
  def default = 0


object Typeclasses extends playground.Test("Typeclasses") {

  override def test() = {
    import Nat.*
    println("Testing Nats!")
    println(less(Succ(Zero) - Succ(Zero), Succ(Zero)))

    
    val i: Int = Default.default // Nice !
    println(i)
  }
}