name := "dott-challenge"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies += "com.github.scopt" %% "scopt" % "4.0.0"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"

mainClass in assembly := Some("dott.Main")
assemblyJarName in assembly := "orders.jar"