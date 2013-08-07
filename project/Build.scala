import sbt._
import Keys._

object ApplicationBuild extends Build {

  val root = Project("benchmarks", file("."))
    .settings(
      name := "benchmarks",
      scalaVersion := "2.10.1",
      version := "1.0-SNAPSHOT",
      resolvers := Seq(
        "Maven Central" at "http://repo1.maven.org/maven2/",
        "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases",
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
      ),
      libraryDependencies ++= Seq(
        "com.google.code.java-allocation-instrumenter" % "java-allocation-instrumenter" % "2.0",
        "com.google.code.gson" % "gson" % "1.7.1",
        "com.google.caliper" % "caliper" % "0.5-rc1"
      ),
      fork in run := true,
      javaOptions in run <++= (fullClasspath in Runtime) map { cp => Seq("-cp", sbt.Build.data(cp).mkString(":")) })
}
