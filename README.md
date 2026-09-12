# E-Commerce Test Automation Framework

A scalable **Hybrid Test Automation Framework** built using **Java, Selenium WebDriver, REST Assured, TestNG, and Maven** for automating an e-commerce application.

The framework demonstrates UI automation, REST API automation, Page Object Model, data-driven testing, parallel execution, logging, screenshots, reusable utilities, and maintainable framework architecture.

---

## Application Under Test

**Automation Exercise**

https://automationexercise.com/

---

## Tech Stack

| Technology         | Purpose                       |
| ------------------ | ----------------------------- |
| Java               | Programming Language          |
| Selenium WebDriver | UI Automation                 |
| REST Assured       | REST API Automation           |
| TestNG             | Test Execution & Assertions   |
| Maven              | Build & Dependency Management |
| WebDriverManager   | WebDriver Management          |
| Log4j2             | Logging                       |
| JSON               | Test Data Management          |
| Git & GitHub       | Version Control               |

---

## Framework Architecture

```text
E-Commerce_Test-Automation-Framework
│
├── src
│   │
│   ├── main
│   │   ├── java
│   │   │   └── com.ecommerce
│   │   │
│   │   │   ├── api
│   │   │   │   ├── AuthApi.java
│   │   │   │   ├── BaseApi.java
│   │   │   │   ├── ProductApi.java
│   │   │   │   └── UserApi.java
│   │   │   │
│   │   │   ├── config
│   │   │   │   └── ConfigReader.java
│   │   │   │
│   │   │   ├── constants
│   │   │   │   └── FrameworkConstants.java
│   │   │   │
│   │   │   ├── driver
│   │   │   │   ├── DriverFactory.java
│   │   │   │   └── DriverManager.java
│   │   │   │
│   │   │   ├── exceptions
│   │   │   │   └── FrameworkException.java
│   │   │   │
│   │   │   ├── listeners
│   │   │   │   └── TestListener.java
│   │   │   │
│   │   │   ├── models
│   │   │   │   ├── Product.java
│   │   │   │   └── User.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   ├── RegisterPage.java
│   │   │   │   └── SearchPage.java
│   │   │   │
│   │   │   └── utils
│   │   │       ├── JavascriptUtils.java
│   │   │       ├── RandomdataUtils.java
│   │   │       ├── ScreenshotUtils.java
│   │   │       └── WaitUtils.java
│   │   │
│   │   └── resources
│   │       ├── config
│   │       │   └── config.properties
│   │       ├── testdata
│   │       │   └── testdata.json
│   │       └── log4j2.xml
│   │
│   └── test
│       └── java
│           └── com.ecommercetest.tests
│               ├── BaseTest.java
│               │
│               ├── api
│               │   ├── AuthApiTest.java
│               │   ├── CreateAccountApiTest.java
│               │   ├── DeleteAccountApiTest.java
│               │   ├── GetUserDetailApiTest.java
│               │   ├── ProductApiTest.java
│               │   ├── SearchProductApiTest.java
│               │   └── UpdateAccountApiTest.java
│               │
│               └── ui
│                   ├── CartTest.java
│                   ├── CheckoutTest.java
│                   ├── LoginTest.java
│                   ├── ProductTest.java
│                   ├── RegisterTest.java
│                   └── SearchTest.java
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

## Framework Design

The framework follows a modular and reusable architecture.

### Page Object Model

The UI automation layer follows the **Page Object Model (POM)** design pattern.

Each application page has a dedicated Page Object class containing:

* Locators
* Page actions
* Reusable methods
* Page-specific functionality

Examples:

```text
HomePage
LoginPage
RegisterPage
SearchPage
ProductPage
CartPage
CheckoutPage
```

This keeps test classes clean and improves maintainability.

---

## BasePage

`BasePage` contains common UI operations that can be reused by all Page Objects.

Examples:

* Click
* Type
* Clear
* Get Text
* Wait for visibility
* Wait for clickability
* JavaScript fallback click
* Popup handling

This avoids duplicating common Selenium code across Page Objects.

---

## WebDriver Management

The framework uses:

* `DriverFactory`
* `DriverManager`
* `ThreadLocal<WebDriver>`

`DriverFactory` is responsible for WebDriver initialization.

`DriverManager` maintains the WebDriver instance for the current execution thread.

```java
private static final ThreadLocal<WebDriver> DRIVER =
        new ThreadLocal<>();
```

This design supports **parallel test execution** and prevents different test threads from sharing the same WebDriver instance.

---

## Parallel Execution

TestNG is configured for parallel execution.

Example:

```xml
<suite name="E-Commerce Automation Suite"
       parallel="classes"
       thread-count="4">
</suite>
```

This allows multiple test classes to execute concurrently.

The combination of:

```text
TestNG Parallel Execution
        +
ThreadLocal<WebDriver>
        +
DriverFactory
        +
DriverManager
```

provides thread-safe browser management.

---

## UI Automation

The framework automates important e-commerce user flows.

### UI Test Scenarios

* User Registration
* User Login
* Product Search
* Product Validation
* Add Product to Cart
* Cart Validation
* Checkout Flow

UI tests are organized separately from API tests for better maintainability.

---

## API Automation

REST API automation is implemented using **REST Assured**.

The API layer follows a reusable design using:

```text
BaseApi
   │
   ├── AuthApi
   ├── UserApi
   └── ProductApi
```

### API Test Coverage

* Authentication
* Create User Account
* Get User Details
* Update User Account
* Delete User Account
* Get Products
* Search Products

API request and response handling is separated from test classes to improve reusability.

---

## Data-Driven Testing

Test data is externalized from test classes using JSON.

Location:

```text
src/main/resources/testdata/testdata.json
```

Example:

```json
{
  "search": {
    "validProduct": "Blue Top",
    "anotherProduct": "Men Tshirt",
    "invalidProduct": "NonExistingProduct123"
  }
}
```

This approach avoids hardcoding test data directly inside automation scripts and makes the framework easier to maintain.

---

## Configuration Management

Application and execution configuration is maintained in:

```text
config.properties
```

Example:

```properties
browser=chrome
url=https://automationexercise.com/
```

`ConfigReader` is responsible for reading configuration values.

This allows configuration values to be changed without modifying test code.

---

## Wait Strategy

The framework uses reusable explicit wait utilities through:

```text
WaitUtils
```

This helps synchronize Selenium operations with application behavior and reduces flaky tests caused by timing issues.

---

## JavaScript Utilities

`JavascriptUtils` provides reusable JavaScript operations such as:

* Scrolling to elements
* JavaScript click
* Browser-level interactions when required

JavaScript is used as a fallback where normal Selenium interaction is intercepted or unavailable.

---

## Random Test Data

`RandomdataUtils` provides dynamically generated test data where required.

This is particularly useful for scenarios such as user registration where unique test data may be required for every execution.

---

## Screenshots

Screenshots are captured automatically when a test fails.

The framework uses:

```text
ScreenshotUtils
        ↓
TestListener
        ↓
Failure Screenshot
```

Failure screenshots are stored for debugging failed test executions.

---

## Logging

The framework uses **Log4j2** for execution logging.

Logging is implemented for important framework events such as:

* Test start
* Test success
* Test failure
* Test skip
* WebDriver initialization
* Application launch
* Screenshot capture
* WebDriver teardown

Log configuration is maintained in:

```text
src/main/resources/log4j2.xml
```

---

## TestNG Listener

A custom TestNG listener is implemented using:

```text
ITestListener
```

The listener handles events such as:

* Test Start
* Test Success
* Test Failure
* Test Skip

On test failure, the listener captures a screenshot using `ScreenshotUtils` and logs the screenshot path for debugging.

---

## Test Execution Flow

```text
TestNG
   │
   ▼
BaseTest
   │
   ▼
ConfigReader
   │
   ▼
DriverFactory
   │
   ▼
DriverManager
   │
   ▼
Page Objects / API Classes
   │
   ▼
Test Execution
   │
   ├── Pass
   │
   ├── Skip
   │
   └── Fail
          │
          ▼
     TestListener
          │
          ▼
  ScreenshotUtils
          │
          ▼
  Failure Screenshot
```

---

## How to Run the Tests

### Run all tests using Maven

```text
mvn clean test
```

### Run tests using TestNG suite

```text
mvn test -DsuiteXmlFile=testng.xml
```

---

## Maven

The project uses Maven for:

* Dependency management
* Build management
* Test execution
* Plugin configuration

Dependencies are maintained in:

```text
pom.xml
```

---

## Key Framework Features

* Selenium WebDriver UI Automation
* REST Assured API Automation
* Page Object Model
* TestNG
* Maven
* Parallel Test Execution
* Thread-Safe WebDriver Management
* Data-Driven Testing
* JSON Test Data
* Configuration Management
* Explicit Waits
* JavaScript Utilities
* Random Test Data Generation
* Failure Screenshot Capture
* TestNG Listeners
* Log4j2 Logging
* Reusable API Layer
* Reusable Page Objects
* Modular Framework Architecture

---

## Project Objective

The objective of this project is to demonstrate practical **SDET-level test automation skills** by building a maintainable automation framework that covers both UI and REST API testing.

The framework focuses on:

* Reusability
* Maintainability
* Scalability
* Parallel execution
* Test data management
* Failure debugging
* Clean test architecture

---

## Author

**QA Automation / SDET**

```text
Java | Selenium | REST Assured | TestNG | Maven | API Automation
```
