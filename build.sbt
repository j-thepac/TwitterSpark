name := "TwitterProject"

version := "0.1"

scalaVersion := "2.12.13"
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.3.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.3.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.3.0"
libraryDependencies += "org.twitter4j" % "twitter4j-core" % "3.0.6"
libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "3.0.6"
libraryDependencies += "org.apache.bahir" %% "spark-streaming-twitter" % "2.4.0"
