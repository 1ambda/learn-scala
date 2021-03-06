name := "learning-shapeless"

version := "1.0"

scalaVersion := "2.11.7"

val scalazVersion = "7.1.5"
val doobieVersion = "0.2.2"
val monocleVersion = "1.2.0-M1" // or "1.3.0-SNAPSHOT"

resolvers ++= Seq(
  "tpolecat" at "http://dl.bintray.com/tpolecat/maven",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
)

libraryDependencies ++= Seq(
  "org.scalaz"                  %% "scalaz-core"               % scalazVersion,
  "org.scalaz"                  %% "scalaz-concurrent"         % scalazVersion,
  "org.scalaz"                  %% "scalaz-effect"             % scalazVersion,
  "org.scalaz"                  %% "scalaz-typelevel"          % "7.1.3",
  "org.scalaz"                  %% "scalaz-scalacheck-binding" % scalazVersion,
  "org.spire-math"              %% "spire"                     % "0.11.0",
  "org.scalatest"               %% "scalatest"                 % "3.0.0-M5",
  "org.json4s"                  %% "json4s-jackson"            % "3.3.0",
  "org.json4s"                  %% "json4s-scalaz"             % "3.3.0",
  "com.chuusai"                 %% "shapeless"                 % "2.2.5",
  "io.spray"                    %% "spray-json"                % "1.3.2",
  "com.github.fommil"           %% "spray-json-shapeless"      % "1.1.0",
  "org.tpolecat"                %% "doobie-core"               % doobieVersion,
  "org.tpolecat"                %% "doobie-contrib-h2"         % doobieVersion,
  "org.tpolecat"                %% "doobie-contrib-specs2"     % doobieVersion,
  "com.github.nscala-time"      %% "nscala-time"               % "2.2.0",
  "com.github.julien-truffaut"  %% "monocle-core"              % monocleVersion,
  "com.github.julien-truffaut"  %% "monocle-generic"           % monocleVersion,
  "com.github.julien-truffaut"  %% "monocle-macro"             % monocleVersion,
  "com.github.julien-truffaut"  %% "monocle-state"             % monocleVersion,
  "com.github.julien-truffaut"  %% "monocle-law"               % monocleVersion % "test"

)

// for @Lenses macro support
addCompilerPlugin("org.scalamacros" %% "paradise" % "2.0.1" cross CrossVersion.full)

connectInput in run := true
initialCommands in console := "import scalaz._, Scalaz._, shapeless._, poly._"
