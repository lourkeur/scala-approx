package lourkeur.approx.scalacheck

import lourkeur.approx._

import org.scalacheck._

import Prop._

object SyntaxProperties extends Properties("Syntax") {
  property("success recognition") =
    forAll { (act: Double, exp: Double, description: String) =>
      implicit val am = new ApproximationMethod {
        override def aeq(a: Double, b: Double) = true
        override def toString = description
      }
      val r = (exp ≈? act).apply(Gen.Parameters.default)
      r.proved
    }
  property("error reporting") =
    forAll { (act: Double, exp: Double) =>
      implicit val am = new ApproximationMethod {
        override def aeq(a: Double, b: Double) = false
        override def toString = description
      }
      val r = (act ?≈ exp).apply(Gen.Parameters.default)
      all(
        r.failure,
        r.labels contains f"Expected approximately $exp (via $description) but got $act",
        )
    }
}
