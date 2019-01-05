package lourkeur.approx

import org.scalacheck._

object SimpleEpsilonProperties extends Properties("SimpleEpsilonProperties") {
  import Prop._

  implicit val am = SimpleEpsilon()

  property("Each double is considered approximately equal to itself") =
    forAll { a: Double =>
      val b = a
      a =≈ b
    }

  property("Large enough random doubles are very probably not approximately equal") =
    forAll { a: Double =>
      a.abs > 1e-9 ==>
        forAll { b: Double =>
          a !≈ b
        }
    }

  property("Close doubles are considered approximately equal") =
    forAll { a: Double =>
      forAll(Gen.choose(a-1e-9, a+1e-9)) { b =>
        a =≈ b
      }
    }
}
