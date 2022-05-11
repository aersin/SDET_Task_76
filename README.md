


# General SDET Task
## Task No: 76
## Type: Desktop Web Automation

[![Build Status](https://travis-ci.org/davidggevorgyan/automationpractice.svg?branch=master)](https://travis-ci.org/davidggevorgyan/automationpractice)

### Following tools were used in this framework:
Maven, JUnit, Selenium WebDriver, Cucumber Reports,
All automation is done in Java.


### Project Design:
* Page Object Model (POM) design pattern
* Singleton design pattern
* DDT with scenario outline
* Have a supporting utilities package in *src/test/java/com/NFL* file path, named ***"utilities"*** that includes classes which services as a core engine for the project
* Special for this task I prefer to put framework and tests in the same place 

### How to run the project main test cases locally:
* A properties file ***"configuration.properties"*** can be found it *configuration.properties* file path including all the configurations needed in the execution
* Can find the test cases in the *src/test/resources* folder mainly in the *features* package
* Can find the *report.html* in the *test-output/Screenshots* folder for failed test scenarios
* Mission 1 is handled under the *src/test/java/com/NFL/pages* folder in Java Class name *Mission_1*


