package lourkeur

package object approx extends Syntax with Implicits {
  type DistanceFunction[T] = (T, T) => Double
  /** Default epsilon value. (10⁻⁹)
    *
    * @see [[SimpleEpsilon]], [[UlpEpsilon]]
    */
  final val DefaultEpsilon = 1e-9
}
