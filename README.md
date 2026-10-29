# Selenium Java Hybrid Framework

## Overview
An industry-oriented Selenium automation framework built using Java, Selenium WebDriver, TestNG, and Maven.

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git and GitHub
- ExtentReports

## Framework Features
- Page Object Model (POM)
- Reusable utility methods
- Explicit waits
- Configuration using `config.properties`
- TestNG annotations and test execution
- Data-driven testing using `@DataProvider`
- Automated screenshots on test failures
- HTML execution reports using ExtentReports
- Maven dependency management

## Project Structure
```text
src/main/java
  ├── com.config
  ├── com.driver
  ├── com.pages
  └── com.utils

src/test/java
  ├── com.base
  ├── com.tests
  └── com.listeners

src/test/resources
  └── config.properties
```

## How to Run
1. Clone this repository.
2. Import the project into Eclipse as an Existing Maven Project.
3. Update `config.properties` if required.
4. Run `testng.xml` as a TestNG Suite.

## Reports
Execution reports and failure screenshots are generated in the `test-output` directory.

## Author
Vuddagiri Akhil Krishna Gupta
