val commonSettings = List(
  organization := "lourkeur",
  scalaVersion := "2.12.7",
  version      := "0.1.0-SNAPSHOT",
  )

lazy val root = (project in file("."))
  .settings(
    inThisBuild(commonSettings),
    name := "approx",
    libraryDependencies += libraries.Scalacheck % Test,
    )

lazy val scalacheck = project
  .settings(
    inThisBuild(commonSettings),
    name := "approx-scalacheck",
    libraryDependencies += libraries.Scalacheck,
    )
  .dependsOn(root)
