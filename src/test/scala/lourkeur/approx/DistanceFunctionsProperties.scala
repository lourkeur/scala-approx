package lourkeur.approx

import org.scalacheck._

object DistanceFunctionsProperties extends Properties("DistanceFunctions") {
  import Prop._

  private def isDistanceFunction[T: Arbitrary](d: DistanceFunction[T]) =
    all(
      forAll { a: T =>
        (d(a, a) == 0) :| "Identity of indescernibles (1)"
      },
      forAll { (a: T, b: T) =>
        all(
          (d(a, b) >= 0) :| "Non-negativity",
          (d(a, b) != 0) ==> (a != b) :| "Identity of indiscernibles (2)",
          (d(a, b) == d(b, a)) :| "Symmetry")
      },
      forAll { (a: T, b: T, c: T) =>
        (d(a,b) + d(b,c) >= d(a,c)) :| "Triangle Inequality"
      })
  property("simpleDistance is a proper distance function") =
    isDistanceFunction(DistanceFunctions.simpleDistance)
  property("ulpDistance is a proper distance function") =
    isDistanceFunction(DistanceFunctions.ulpDistance)
}
