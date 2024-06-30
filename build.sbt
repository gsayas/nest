name := """nest"""
organization := "io.giosayas"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.14"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.5.1"
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.18"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "io.giosayas.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "io.giosayas.binders._"
