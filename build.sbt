enablePlugins(ScalaJSBundlerPlugin)

name := "scalajs-react-sidebar"

organization := "io.suggest"

version := "3.0.2"

testFrameworks += new TestFramework("minitest.runner.Framework")

// Show more comments when using dubious features
scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "1.7.5",
  "com.github.japgolly.scalajs-react" %%% "test" % "1.7.5" % Test,
  "io.monix"      %%% "minitest" % "2.+" % Test,
)

npmDependencies in Compile ++= Seq(
  "react" -> "16.13.1",
  "react-dom" -> "16.13.1",
  "react-sidebar" -> version.value,
)

useYarn := true

requireJsDomEnv in Test := true
