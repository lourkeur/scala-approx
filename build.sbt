import Dependencies._

val commonSettings = List(
  organization := "lourkeur",
  scalaVersion := "2.12.7",
  version      := "0.1.0-SNAPSHOT"
)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(commonSettings),
    name := "approx",
    libraryDependencies += scalaCheck % Test
  )

lazy val check = (project in file("scalacheck")).
  settings(
    inThisBuild(commonSettings),
    name := "approx-scalacheck",
    libraryDependencies += scalaCheck
  ) dependsOn root
