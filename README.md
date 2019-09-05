# CucumberFrameworkWithSelenium
A BDD test framework build using Maven and implemented Cucumber, JUnit and Selenium in it.

About this framework.
  - This BDD test framework is developed mainly using Cucumber, Selenium with java bindings.
  - This framework can run N numbers of features file by generating a Runner class at runtime.
  - This framework can run 4 tests parallelly(can be re-configured in POM.xml file - by updating forkCount)
  - This framework also capture screenshot on test failure and attach it to html report.
  - Execution can be run in headless mode also(Depending on the browser you pass while running).
  - It generate 2 type of reports.
	- JSON(inside path : target/cucumber-parallel/)
	- HTML report(inside path : target/Cucumber-html-report/cucumber-html-reports)

To run tests, use below command.
  - mvn clean verify -Dbrowser=chrome -Dtag=@Login,@Test.
  - Above command accepts 2 paramters as of now.
  	- Browser name(On which browser all the test needs to be run)
	- tag(What all tags to be run from features file)
	
Just for testing purpose/for example, this framework is implemented on dummy testing website, can be totally re-configured to automate any other websites.
