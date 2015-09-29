organization := "com.feth"

name := """escarbajo"""

scalaVersion := "2.11.6"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

val appDependencies = Seq(
  "be.objectify"  %% "deadbolt-java"     % "2.4.0",
  // Comment the next line for local development of the Play Authentication core:
  "com.feth"      %% "play-authenticate" % "0.7.0-SNAPSHOT",
  "org.postgresql"    %  "postgresql"        % "9.4-1201-jdbc41",
  cache,
  javaWs,
  javaJdbc,
  "org.webjars" % "bootstrap" % "3.2.0",
  "org.easytesting" % "fest-assert" % "1.4" % "test"
)

routesGenerator := InjectedRoutesGenerator

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes 
EclipseKeys.preTasks := Seq(compile in Compile)                  // Compile the project before generating Eclipse files, so that .class files for views and routes are present
