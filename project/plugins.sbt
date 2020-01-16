logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % Option(System.getProperty("play.version")).getOrElse("2.6.17"))

addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "4.0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.2.2")
