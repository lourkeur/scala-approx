package lourkeur.approx

final case class UlpEpsilon(epsilon: Double = DefaultEpsilon)
    extends ApproximationMethod.FromDistanceFunction(
  DistanceFunctions.ulpDistance,
  epsilon / math.ulp(1.0),
  )
