ThisBuild / organization := "magic.association"


val scala3Version = "3.0.0"
val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"
val junit = "com.novocode" % "junit-interface" % "0.11"

lazy val root = (project in file(".")).settings (

  name := "scala3-playground",
  version := "0.1.0",

  scalaVersion := scala3Version,

  libraryDependencies += junit % "test",
  libraryDependencies += scalaTest % "test",
)

