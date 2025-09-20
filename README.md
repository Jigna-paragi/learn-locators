# Learn Locators – Selenium + TestNG + Maven + Allure

This project is designed for practicing **Selenium locators** and building a robust automation framework using  
**Java, Maven, TestNG, and Allure Reports**.  
The practice site used is [The Internet Heroku App](https://the-internet.herokuapp.com/).

## 📂 Project Structure
learn-locators/
├── pom.xml # Maven dependencies (Selenium, TestNG, WebDriverManager, Allure)
├── testng.xml # TestNG suite configuration
├── src/
│ └── test/java/
│ ├── tests/ # Test classes (HerokuLoginTest, CheckboxesTest, etc.)
│ ├── pages/ # Page Object Model (POM) classes
│ └── utils/ # BaseTest, listeners, helpers
└── target/
├── test-classes/ # Compiled test classes
└── allure-results/ # Test execution results (for Allure)


## ⚙️ Prerequisites
- **Java 11 or above** installed and set in PATH
- **Maven 3.6+** installed and set in PATH
- **Allure CLI** installed and set in PATH (`allure --version` should work)
- IDE (**IntelliJ IDEA** or **Eclipse**) – recommended

## ▶️ Running Tests

Run all tests (via TestNG suite):
```bash
mvn clean test



mvn -Dtest=tests.HerokuLoginTest test

mvn -Dtest=tests.HerokuLoginTest#testValidLogin test

mvn allure:serve

allure generate target/allure-results -o target/site/allure-report --clean
allure open target/site/allure-report

Run smoke group:
mvn -Dgroups=smoke test

Run regression:
mvn -Dgroups=regression test

Or run a specific class/method:
mvn -Dtest="tests.DropdownTest#testDropdownSelections" test
