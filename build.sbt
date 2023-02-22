version in ThisBuild := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.12"

lazy val root = (project in file("."))
  .settings(
    name := "SparkX"
  )

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"

