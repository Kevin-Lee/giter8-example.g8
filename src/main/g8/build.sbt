ThisBuild / scalaVersion := "2.13.4"
ThisBuild / version := SbtProjectInfo.ProjectVersion
ThisBuild / organization := "io.kevinlee"
ThisBuild / organizationName := ""
ThisBuild / developers := List(
  Developer(
    props.GitHubUsername,
    "$author_name$",
    "$author_email$",
    url(s"https://github.com/\${props.GitHubUsername}"),
  )
)
ThisBuild / homepage := Some(url(s"https://github.com/\${props.GitHubUsername}/\${props.RepoName}"))
ThisBuild / scmInfo :=
  Some(
    ScmInfo(
      url(s"https://github.com/\${props.GitHubUsername}/\${props.RepoName}"),
      s"https://github.com/\${props.GitHubUsername}/\${props.RepoName}.git",
    )
  )

lazy val root = (project in file("."))
  .settings(
    name := props.ProjectName
  )
  .settings(noPublish)

lazy val props =
  new {
    val GitHubUsername = "$github_username$"
    val RepoName       = "$repo_name$"
    val ProjectName    = RepoName
  }

lazy val noPublish: SettingsDefinition = Seq(
  publish := {},
  publishLocal := {},
  publishArtifact := false,
  skip in sbt.Keys.`package` := true,
  skip in packagedArtifacts := true,
  skip in publish := true,
)
