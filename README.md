# Ecommerce Automation Framework

A Java-based web UI automation framework built using **Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)**.

The framework is designed to automate end-to-end e-commerce workflows and demonstrate reusable automation framework practices such as data-driven testing, reusable browser setup, explicit waits, logging, screenshots, test grouping, and configuration management.

##  Tech Stack

* **Language:** Java 17
* **Automation:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Test Data:** Excel
* **Logging:** Log4j2
* **Reporting:** ExtentReports
* **Browser Management:** WebDriverManager
* **Version Control:** Git & GitHub
* **IDE:** Eclipse

##  Key Features

* Page Object Model for maintainable test automation
* Reusable WebDriver initialization and browser management
* TestNG annotations and test execution
* TestNG groups such as Smoke and Regression
* Data-driven login testing using Excel
* Explicit waits for synchronization
* Configuration management using properties files
* Logging using Log4j2
* Screenshot utility for test execution
* Retry mechanism for failed tests
* Maven-based test execution
* Support for Chrome and Edge browsers

## Automated Test Scenarios

The framework currently covers:

* Valid login
* Invalid login
* Locked-user login
* Logout
* Add product to cart
* Remove product from cart
* Checkout workflow
* End-to-end e-commerce workflow

##  Project Structure

```text
EcommerceAutomationFramework/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── com/automation/base/
│       │   │   ├── BaseTest.java
│       │   │   ├── BrowserFactory.java
│       │   │   └── DriverFactory.java
│       │   │
│       │   ├── listeners/
│       │   │   ├── RetryAnalyzer.java
│       │   │   └── TestListener.java
│       │   │
│       │   ├── pages/
│       │   │   ├── LoginPage.java
│       │   │   ├── ProductsPage.java
│       │   │   ├── CartPage.java
│       │   │   ├── CheckoutPage.java
│       │   │   └── ...
│       │   │
│       │   ├── tests/
│       │   │   ├── LoginTest.java
│       │   │   ├── LogoutTest.java
│       │   │   ├── AddToCartTest.java
│       │   │   ├── RemoveFromCartTest.java
│       │   │   ├── CheckoutTest.java
│       │   │   └── EndToEndTest.java
│       │   │
│       │   └── utils/
│       │       ├── ConfigReader.java
│       │       ├── DataProviderUtility.java
│       │       ├── ExcelUtility.java
│       │       ├── ScreenshotUtility.java
│       │       ├── WaitUtility.java
│       │       └── WebDriverUtility.java
│       │
│       └── resources/
│           ├── config/
│           │   └── config.properties
│           ├── testdata/
│           │   └── LoginData.xlsx
│           └── log4j2.xml
│
├── .gitignore
├── pom.xml
└── testng.xml
```

##  How to Run

### Prerequisites

Make sure the following are installed:

* Java 17 or higher
* Maven
* Git
* Chrome or Microsoft Edge
* Eclipse or another Java IDE

### Clone the Repository

```bash
git clone https://github.com/SnehalKullolli/EcommerceAutomationFramework.git
```

### Navigate to the Project

```bash
cd EcommerceAutomationFramework
```

### Run Tests Using Maven

```bash
mvn test
```

### Run Using TestNG XML

The framework also supports execution through the `testng.xml` suite file.

## Test Data

Login test data is maintained in:

```text
src/test/resources/testdata/LoginData.xlsx
```

The framework uses TestNG `DataProvider` to read multiple login scenarios from the Excel file.

Example scenarios include:

| Scenario            | Expected Result     |
| ------------------- | ------------------- |
| Valid user          | Successful login    |
| Invalid credentials | Error message       |
| Locked user         | Locked-user message |

##  Configuration

Browser and application configuration are maintained in:

```text
src/test/resources/config/config.properties
```

This allows browser and application settings to be changed without modifying the test classes.

##  Logging

The framework uses **Log4j2** for test execution logging.

Logs help track:

* Test execution
* Login actions
* Validation steps
* Test flow
* Errors and debugging information

##  Screenshots

The framework contains a reusable screenshot utility for capturing screenshots during test execution.

Generated screenshots and execution artifacts are excluded from Git using `.gitignore`.

## Future Enhancements

Planned improvements include:

* CI/CD integration using Jenkins or GitHub Actions
* Cross-browser execution
* Parallel test execution
* Enhanced HTML reporting
* Cucumber BDD integration
* Docker-based test execution

## Author

**Snehal Kullolli**

Java | Selenium | TestNG | API Testing | SQL 
