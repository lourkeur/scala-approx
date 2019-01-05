package lourkeur.approx

trait Syntax {
  implicit final class ApproxOps[T: ApproxEq](
    lhs: T
  )(
    implicit approximationMethod: ApproximationMethod
  ) {
    def aeq(rhs: T) =
      ApproxEq[T].aeq(lhs, rhs)
    def naeq(rhs: T) =
      !(ApproxEq[T].aeq(lhs, rhs))
    def =≈(rhs: T) = aeq(rhs)
    def !≈(rhs: T) = naeq(rhs)
  }
}
