package lourkeur.approx

import org.scalacheck._

object UlpEpsilonProperties extends Properties("UlpEpsilonProperties") {
  import Prop._

  implicit val am = new UlpEpsilon

  property("Each double is considered approximately equal to itself") =
    forAll { a: Double =>
      val b = a
      a =≈ b
    }

  property("Random doubles are very probably not approximately equal") =
    forAll { (a: Double, b: Double) =>
      a !≈ b
    }

  property("Close doubles are considered approximately equal") =
    forAll { a: Double =>
      forAll(Gen.choose(-.5e-9, .5e-9)) { x =>
        val b = (1+x) * a
        a =≈ b
      }
    }
}
