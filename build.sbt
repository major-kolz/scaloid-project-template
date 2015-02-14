import android.Keys._

val scaloid = "org.scaloid" %% "scaloid" % "3.6.1-10"
val proguard = "net.sf.proguard" % "proguard-base" % "5.0"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

android.Plugin.androidBuild

lazy val root = (project in file(".")).
  settings(
    name := "Third lesson",
    version := "0.1",
    scalaVersion := "2.11.4",
    libraryDependencies ++= Seq(
      scaloid withSources() withJavadoc(),
      proguard
    )
  )

proguardCache in Android ++= Seq(
  ProguardCache("org.scaloid") % "org.scaloid"
)

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-keepattributes Signature", "-printseeds target/seeds.txt", "-printusage target/usage.txt"
  , "-dontwarn scala.collection.**" // required from Scala 2.11.4
)

scalacOptions in Compile ++= Seq( "-feature", "-deprecation" )

run <<= run in Android

install <<= install in Android
