package lourkeur.approx.scalacheck

import lourkeur.approx._

import org.scalacheck._
import org.scalacheck.util._

import Prop._

object Core {
  def ?≈[T: ApproxEq](x: T, y: T)(implicit am: ApproximationMethod, pp: T => Pretty): Prop =
    if (x =≈ y) proved else falsified :| {
      val exp = Pretty.pretty[T](y, Pretty.Params(0))
      val act = Pretty.pretty[T](x, Pretty.Params(0))
      f"Expected approximately $exp (via $am) but got $act"
    }

  def ≈?[T: ApproxEq](x: T, y: T)(implicit am: ApproximationMethod, pp: T => Pretty): Prop =
    ?≈(y, x)
}
