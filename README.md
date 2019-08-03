READ ME

The automation test is to ensure the categories on left side menu are functional:
.Filter
.Sort
.Details

In order to start the automaiton test, you will need to:
.Install IntelliJ IDEA
.Install Java JDK 8.0
.Install apache-maven-3.5.3-src.zip

.Open InteliJ, import pom.xml as project
.Enable "Import Maven projects automatically"(Settings/Build, Execution, Deployment/Builds tool/Maven/Importing)
.Find and install plugin "Cumcumber for Java", "Gherkin" (Settings/Plugins)

.To run with maven:
1. Select Edit Configuration , press "+", select Maven, enter "clean install" in Command line

.To run with JUnit:
1. Right click on the feature file, then select Run

The report after the test can be find in folder: target/site/serenity/index.html