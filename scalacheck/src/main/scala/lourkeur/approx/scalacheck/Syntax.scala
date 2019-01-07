package lourkeur.approx.scalacheck

import lourkeur.approx._

import org.scalacheck._
import org.scalacheck.util._

trait Syntax {
  implicit final class ApproxPropOps[T: ApproxEq](x: T) {
    def ?≈(y: T)(implicit am: ApproximationMethod, pp: T => Pretty): Prop =
      Core.?≈(x, y)
    def ≈?(y: T)(implicit am: ApproximationMethod, pp: T => Pretty): Prop =
      Core.≈?(x, y)
  }
}
