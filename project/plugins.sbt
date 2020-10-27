addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.6.1")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.2")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.3.0")

addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.20.0")

addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.1" cross CrossVersion.full)

// for-yield-optimising (https://github.com/fosskers/scalaz-and-cats#i-chain-operations-with-for--yield-isnt-that-all-i-need)
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")

