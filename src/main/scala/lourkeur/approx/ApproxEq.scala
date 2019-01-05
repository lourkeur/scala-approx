package lourkeur.approx

/** Add the operators to any type. */
trait ApproxEq[T] {
  def aeq(lhs: T, rhs: T)(implicit am: ApproximationMethod): Boolean
}

object ApproxEq {
  def apply[T](implicit ae: ApproxEq[T]) = ae
}
