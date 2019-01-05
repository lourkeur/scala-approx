package lourkeur.approx

trait Implicits {
  implicit val approximationMethod: ApproximationMethod = new SimpleEpsilon
  implicit val doublePartialEq = new ApproxEq[Double]{
    override def aeq(lhs: Double, rhs: Double)(implicit am: ApproximationMethod) =
      am.aeq(lhs, rhs)
  }
}
