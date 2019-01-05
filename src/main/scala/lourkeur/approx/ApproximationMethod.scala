package lourkeur.approx

/** SAM trait for reified approximation methods.
  *
  * @see [[SimpleEpsilon]], [[UlpEpsilon]]
  */
trait ApproximationMethod {
  /** test if ''a'' and ''b'' are close to each other, according to the
    * criterion of this.
    */
  def aeq(a: Double, b: Double): Boolean
}
object ApproximationMethod {
  abstract class FromDistanceFunction(
    distanceFunction: DistanceFunction[Double],
    threshold: Double,
  ) extends ApproximationMethod {
    require(threshold > 0, "proximity threshold must be positive")
    override def aeq(a: Double, b: Double): Boolean =
      distanceFunction(a, b) <= threshold
  }
}
