# CucumberFrameworkWithSelenium
A BDD test framework build using Maven and implemented Cucumber, JUnit and Selenium in it.

About this framework.
  - This BDD test framework is developed mainly using Cucumber, Selenium with java bindings.
  - This framework can run N numbers of features file by generating a Runner class at runtime.
  - This framework can run 4 tests parallelly(can be re-configured in POM.xml file - by updating forkCount)
  - It generate 2 type of reports.
     1 - JSON(inside path : target/cucumber-parallel/)
     2 - HTML report(inside path : target/Cucumber-html-report/cucumber-html-reports)


How to Run via command line using maven.
    - mvn clean verify -Dbrowser=chrome -Dtag=@Login,@Test
Above command accepts 2 parameters as of now,
    1 - Browser name
    2 - What all tags to be run from features file.
    
    
Just for testing purpose/for example, this framework is implemented on dummy testing website, can be totally re-configured to automate any other websites.
