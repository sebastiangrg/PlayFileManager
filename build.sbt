organization := "com.feth"

name := "PlayFileManager"

scalaVersion := "2.12.6"

version := "1.0-SNAPSHOT"

val appDependencies = Seq(
  "com.feth" %% "play-authenticate" % "0.9.0-SNAPSHOT",
  "mysql" % "mysql-connector-java" % "5.1.36",
  javaJdbc,
  cacheApi,
  ehcache,
  javaWs
)

resolvers += Resolver.sonatypeRepo("snapshots")

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)
  .settings(
    libraryDependencies ++= appDependencies
  )