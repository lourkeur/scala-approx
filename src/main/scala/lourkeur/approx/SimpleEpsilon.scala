package lourkeur.approx

final case class SimpleEpsilon(epsilon: Double = DefaultEpsilon)
    extends ApproximationMethod.FromDistanceFunction(
  DistanceFunctions.simpleDistance,
  epsilon,
  )
