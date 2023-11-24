name := "spark-dataframe-example"

version := "0.1"

scalaVersion := "2.13.12"

val sparkVersion = "3.3.3"

libraryDependencies ++= mainLibs

lazy val mainLibs =
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
  )
