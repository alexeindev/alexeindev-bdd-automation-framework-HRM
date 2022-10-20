# Automation Framework 
## Selenium-Cucumber-Java

This Automation framework is part of a Bootcamp practice that uses Selenium and the Cucumber BDD framework with Java as programming language to automate the OrangeHRM (orangehrmlive.com) CRM Web app


## Installation
Installation (pre-requisites)
1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. IntelliJ IDEA (IDE)
4. IntelliJ Plugins for
    - Maven
    - Cucumber
    - Cucumber for Java

Dependencies

- Testng version 7.5
- Selenium java version 4.4
- Webdrivermanager version 5.3
- commons-io version 2.11
- cucumber-testng version 7.3.4 with jUnit exclusion
- cucumber-java version 7.3.4
- cucumber-picocontainer 7.3.4
- cucumber-core 7.3.4

## Framework set-up

Fork / Clone repository from [here]( https://github.com/alexeindev/bdd-automation-framework-HRM) or download zip and set
it up in your local workspace.

Then you might need to set up the following environment variables:
- `browser`: chrome, firefox or edge
- `user`: username to log into the application
- `password`: password to log into the application

## Reports
After the test execution go to the `target/cucumber-reports` folder the open the file cucumber-pretty with your favorite browser to see a formated version of the report

