package lourkeur.approx

trait Syntax {
  implicit final class ApproxOps[T: ApproxEq](lhs: T) {
    def aeq(rhs: T)(implicit am: ApproximationMethod) =
      ApproxEq[T].aeq(lhs, rhs)
    def naeq(rhs: T)(implicit am: ApproximationMethod) =
      !(ApproxEq[T].aeq(lhs, rhs))
    def =≈(rhs: T)(implicit am: ApproximationMethod) =
      aeq(rhs)
    def !≈(rhs: T)(implicit am: ApproximationMethod) =
      naeq(rhs)
  }
}
