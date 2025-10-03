# 📱 Appium Java Automation Framework

A **mobile automation testing framework** built using **Appium, Java, Maven, and TestNG**.  
This framework follows the **Page Object Model (POM)** design pattern to ensure **scalability, maintainability, and reusability**. It automates the testing of a sample Android application (`General-Store.apk`) and demonstrates strong expertise in **mobile QA automation, data-driven testing, and CI/CD readiness**.

---

## 📂 Project Structure

```

appium-automation-java-main
│── pom.xml                      # Maven dependencies & build configuration
│── src
│   ├── main/java/org/...        # Core code (configurations/utilities)
│   ├── test/java
│   │   ├── base/                # Base setup & locators
│   │   │   ├── Base.java
│   │   │   └── Locators.java
│   │   ├── pageObjects/         # Page Object Model classes
│   │   │   ├── HomePage.java
│   │   │   ├── ProductsPage.java
│   │   │   ├── CartPage.java
│   │   │   ├── ProductsAdd.java
│   │   │   └── ProductsDisplay.java
│   │   ├── testcases/           # TestNG test classes
│   │   │   ├── TestHomePageAppear.java
│   │   │   ├── TestProducts.java
│   │   │   ├── TestCheckout.java
│   │   │   └── TestProductsDisplay.java
│   ├── test/resources/          # Test data & config files
│   ├── General-Store.apk        # Sample Android app under test
│── screenshots/                 # Captured screenshots during test runs

````

---

## ⚡ Key Features

- **Page Object Model (POM):** Clean separation of test logic and UI locators.  
- **TestNG Integration:** Parallel execution, grouping, and annotations.  
- **Appium Driver Setup:** Centralized in `Base.java` for reuse across tests.  
- **Reusable Utilities:** Common locators & actions handled via `Locators.java`.  
- **Sample Android App:** `General-Store.apk` included for demonstration.  
- **Screenshots:** Captures on test execution for reporting & debugging.  
- **CI/CD Ready:** Easily integrable with Jenkins/GitHub Actions pipelines.  

---

## 🛠️ Tech Stack

- **Language:** Java  
- **Mobile Automation:** Appium  
- **Testing Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **App Under Test:** General-Store.apk (Android)  
- **IDE:** IntelliJ IDEA / Eclipse  

---

## ▶️ Getting Started

### Prerequisites
- Java JDK 8+  
- Maven 3+  
- Node.js & Appium server (`npm install -g appium`)  
- Android SDK / Emulator or physical device  

### Setup
```bash
# Clone repository
git clone <repo-url>
cd appium-automation-java-main

# Install dependencies
mvn clean install
````

### Run Tests

```bash
# Run all TestNG tests
mvn test

# Run specific test suite
mvn test -DsuiteXmlFile=testng.xml
```

---

## 📊 Reporting

* **Default TestNG Reports:** Generated under `/test-output`.
* **Screenshots:** Stored under `/screenshots` after test execution.

---

## 🎯 Highlights for Portfolio

* Demonstrates **real-world mobile automation** with Appium + Java.
* Implements **best practices in test automation architecture**.
* Showcases **scalable test suites** with reusable components.

