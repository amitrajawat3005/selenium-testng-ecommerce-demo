🛒 Selenium TestNG E-Commerce Demo

A demo automation project showcasing end-to-end testing of an e-commerce application using:

Java

Selenium WebDriver

TestNG

Maven

Extent Reports

This project is designed to demonstrate UI test automation best practices and can serve as a reference for real-world e-commerce testing.

🚀 Features

✔️ Automated test scripts for common e-commerce workflows:

User login

Product search

Add to cart

Checkout flow

✔️ Framework Highlights:

Page Object Model (POM) design pattern

Data-driven testing using TestNG

Parallel execution support

Custom HTML reports with screenshots (Extent Reports)

Logs of test steps using test.log(Status.INFO, "...")

📂 Project Structure
selenium-testng-ecommerce-demo/
│── src/test/java/
│   ├── base/         # Base test setup and driver config
│   ├── pages/        # Page Object classes
│   ├── tests/        # Test classes
│   └── utils/        # Helpers, utilities, reporting
│── testng.xml        # TestNG suite configuration
│── pom.xml           # Maven dependencies
│── README.md         # Project documentation

🛠️ Tech Stack

Java 23

Selenium 4.25.0

TestNG

Maven

Extent Reports

▶️ How to Run

Clone the repo:

git clone https://github.com/amitrajawat3005/selenium-testng-ecommerce-demo.git
cd selenium-testng-ecommerce-demo


Run tests with Maven:

mvn clean test


View test reports:

Reports generated under:

target/test-output/ExtentReport.html

📸 Sample Reports

Screenshots on each test step

Highlighted logs with Status.INFO for better readability

💡 Future Improvements

Add CI/CD integration with GitHub Actions

Support multiple browsers (Chrome, Firefox, Edge)

Add API + UI hybrid testing

👨‍💻 Author

Amit Pratap Singh Kushwah

💼 11+ years in Automation Testing (Selenium, API, Performance, Security)
