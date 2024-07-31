# Selenium Automation Framework

This automation framework leverages cutting-edge tools and libraries to ensure robust and efficient testing of web applications. It features Selenium for browser automation, Extent Reports for detailed reporting, Owner for environment configuration management, Lombok for reducing boilerplate code, Data-Driven Testing capabilities, and Selenium Grid for parallel execution.

## Key Features

### Selenium
- **Comprehensive Browser Automation**: Automates user interactions across multiple browsers.
- **Cross-Browser Compatibility**: Facilitates testing across various browser types and versions.

### Extent Reports
- **Advanced Reporting**: Produces visually rich and detailed test execution reports.
- **Customizable Reports**: Supports extensive customization to match reporting needs.

### Owner
- **Flexible Configuration Management**: Handles properties for different environments (e.g., development, staging, production).
- **Simplified Property Access**: Provides an intuitive API for accessing configuration settings.

### Lombok
- **Code Optimization**: Utilizes annotations to reduce boilerplate code, enhancing readability and maintainability.
- **Enhanced Code Quality**: Focuses on business logic by minimizing repetitive code.

### Data-Driven Testing
- **Versatile Test Data Management**: Supports testing with multiple data sets to validate various scenarios.
- **Separation of Concerns**: Isolates test data from test logic, promoting reuse and flexibility.

### Selenium Grid
- **Scalable Parallel Execution**: Enables concurrent execution of tests across a distributed infrastructure.
- **Efficient Resource Utilization**: Facilitates running tests in parallel, reducing overall execution time.

## Prerequisites

- **Java Development Kit (JDK) 11** or higher
- **Apache Maven** for build and dependency management
- **Docker** (for Selenium Grid setup, if required)

## Setup Instructions

### Cloning the Repository
Clone the repository to your local machine:
```bash
git clone <repository-url>
```

### Navigating to the Project Directory
Change directory to the project root:
```bash
cd AutomationFramework
```

### Installing Dependencies
Install all necessary dependencies using Maven:
```bash
mvn clean install
```

### Executing Tests
**Running Tests Locally**

To execute tests locally, ensure the `runMode` property is set to `local` in the properties file. This will run the tests on your local machine without using a Selenium Grid.
```bash
mvn clean test
```
**Running Tests on Selenium Grid**

For running tests remotely using Selenium Grid, set the `runMode` property to `remote` and the `remoteMode` property to `selenium`. Additionally, specify the URL of the Selenium Grid hub in the `seleniumGridUrl` property. This configuration will direct the tests to be executed on the specified Selenium Grid setup.
```bash
mvn clean test
```
### Reporting
Test results are automatically generated and stored in the extent-test-output directory. Navigate to this directory and open the .html files to view the comprehensive test report.

### Environment Configuration
The framework uses the Owner library to manage configuration properties for different environments. Properties files are located in the src/main/resources/config directory. Select the desired environment by setting the env system property during test execution.

### Data-Driven Testing
Data for test cases is stored in external files such as Excel, located in the src/test/resources/testdata directory. The framework dynamically reads from these data sources, allowing for flexible and scalable testing.

