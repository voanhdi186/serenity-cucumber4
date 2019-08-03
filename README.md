READ ME

The automation test is to ensure the categories on left side menu are functional:

_ Filter

_ Sort

_ Details

In order to start the automaiton test, you will need to:
_ Install IntelliJ IDEA

_ Install Java JDK 8.0

_ Install apache-maven-3.5.3-src.zip

_ Open InteliJ, import pom.xml as project

_ Enable "Import Maven projects automatically"(Settings/Build, Execution, Deployment/Builds tool/Maven/Importing)

_ Find and install plugin "Cucumber for Java", "Gherkin" (Settings/Plugins)

To run with maven:
Select Edit Configuration , press "+", select Maven, enter "clean install" in Command line

To run with JUnit:
Right click on the feature file, then select Run

The report after the test can be find in folder: target/site/serenity/index.html
