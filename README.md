# autotrainingfinal
Base project.

General details of the implementation
The tests use  test, model, page (userinterface). The complete structure of the project is the following:

+ test
     Classes with diferents test to execute

+ page
     Page Elements and methods
+ util
     Utility classes

Requirements
To run the project you need Java JDK 1.8 and Maven preferably with version 3.6

To run the project
You must add the path webdriver, in the file file//config.properties and change DRIVE for path in you machine and file//file.json change the dates.


Then the command can be executed:

mvn clean install -DskipTests
mvn clean test -Dsurefire.suiteXmlFiles=Suite.xml

Reporte

The report is in the folder test-output, you have to search the file .index to see report.
