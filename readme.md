# SauceDemo Automation Framework with Selenium and Cucumber
This repository contains an automation framework built with Selenium, Cucumber, and Java for automating tests on the SauceDemo website.
The framework uses BDD to validate key user workflows, such as logging in, adding products to the cart, and logging out.

# Prerequisites
Before running the project, ensure that you have the following installed:
- IntelliJ IDEA
- Java 21 or higher
- Maven (for dependency management and building the project)

# Setup Instructions
1. Clone the repo
    1. Open IntelliJ IDEA
    2. Navigate to File > New > Project from Version Control
    3. Enter the Repository URL: https://github.com/menna236/SauceDemoAutomation/.git
    4. Click clone
2. Import maven dependencies
    1. Navigate to the pom.xml file in the project
    2. Click View > Tool Windows > Maven. (the Maven tool window will appear on the right-hand side of IntelliJ)
    3. From the Maven window, click the Refresh button (the two circular arrows) to reload the pom.xml file and download the required dependencies

# Running The Tests
1. Navigate to the src/test/java folder in the Project
2. Right-click the TestRunner.java file and select Run 'TestRunner'

