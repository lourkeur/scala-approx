package lourkeur.approx

object DistanceFunctions {

  /** Distance function behind [[SimpleEpsilon]], i.e.the absolute difference.
    */
  val simpleDistance: DistanceFunction[Double] = (a, b) =>
    (a - b).abs

  /** Distance function behind [[UlpEpsilon]].
    */
  val ulpDistance: DistanceFunction[Double] = (a, b) => {
    val δ = a - b
    val μ = math.max(math.ulp(a), math.ulp(b))
    δ.abs / μ
  }

}
