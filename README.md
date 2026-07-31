# Wikipedia Android App – Mobile Automation Framework

A mobile test automation framework for the **Wikipedia Android app**, built with **Java**, **Appium**, **Selenium**, and **TestNG**, using the **Page Object Model (POM)** design pattern and **Allure** for reporting.

## 🚀 Tech Stack

| Tool | Purpose |
|---|---|
| Java | Programming language |
| Appium (UiAutomator2) | Mobile automation driver |
| Selenium | WebDriver core |
| TestNG | Test runner & assertions |
| Allure | Test reporting with `@Step` annotations |
| Maven | Build & dependency management |

## 📁 Project Structure

```
src/main/java
├── base_screen/
│   └── BaseScreen.java        # Shared wait/find logic for all screens
├── base_test/
│   └── BaseTest.java          # Driver setup & teardown lifecycle
├── driver/
│   └── DriverManager.java     # Appium driver singleton
└── screens/
    ├── StartingScreen.java    # Onboarding screens
    ├── HomeScreen.java        # Home / navigation
    ├── SearchScreen.java      # Search functionality
    └── ArticleScreen.java     # Article view, save & reading list

src/test/java
└── tests/
    └── WikipediaTest.java     # Test scenarios
```

## 🧩 Design Pattern

The framework follows the **Page Object Model (POM)**:

- Each app screen has its own class under `screens/`, encapsulating its locators and actions.
- `BaseScreen` centralizes reusable logic (`waitForVisible`, `findElement`) so every screen inherits consistent, safe element interactions.
- `BaseTest` manages the Appium session lifecycle (`@BeforeMethod` / `@AfterMethod`), ensuring each test runs in a clean, isolated session.
- `DriverManager` provides a single, reusable `AndroidDriver` instance per test run and handles proper session teardown via `quitDriver()`.

## ✅ Test Scenario

**`testSaveArticleToReadingList`** — verifies that a user can search for an article, save it to a newly created reading list, and confirm it appears in that list.

Steps (each annotated with Allure `@Step` for clear reporting):

1. Skip onboarding screens
2. Navigate to the search screen
3. Search for a given article
4. Open the first search result
5. Save the article to a new reading list
6. Confirm and view the reading list
7. Verify the article is displayed in the list

## ⚙️ Prerequisites

- Java JDK 17+
- Maven 3.8+
- Appium Server running locally (`http://127.0.0.1:4723`)
- Android device/emulator with the **Wikipedia app** (`org.wikipedia`) installed
- Device capabilities configured in `DriverManager.java` (device name, platform version)

## ▶️ Running the Tests

1. Start Appium server:
   ```bash
   appium
   ```
2. Connect an Android device or start an emulator.
3. Run the tests:
   ```bash
   mvn clean test
   ```
4. Generate and open the Allure report:
   ```bash
   allure serve target/allure-results
   ```

## 📊 Reporting

Test steps are tracked with Allure `@Step` annotations, providing a clear, human-readable breakdown of each action in the report — making it easy to pinpoint exactly where a test failed.

## 🔧 Configuration

Device and app capabilities are defined in `DriverManager.java`:

```java
options.setDeviceName("YOUR_DEVICE_ID");
options.setPlatformVersion("YOUR_OS_VERSION");
options.setAppPackage("org.wikipedia");
options.setAppActivity("org.wikipedia.main.MainActivity");
```

Update these values to match your local device or emulator before running the tests.

## 📌 Notes

- `DriverManager` uses a singleton pattern to avoid creating multiple Appium sessions during a single test run.
- `BaseTest` ensures the driver session is properly closed after each test via `quitDriver()`, preventing leftover sessions on the device.

## 👤 Author

Mohamed Tarek
