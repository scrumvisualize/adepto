# Selenium Web Driver Java project/ TestNG

Selenium web driver Java test automation project created in 'Page Object Model' pattern.
Please make sure you have Java & Eclipse IDE installed in your system.

## Getting Started

The below instructions will get you an idea about how to run the UI tests using TestNg framework.

### Prerequisites

What software/ tools you need to install and their versions

```
Eclipse IDE version: 2019-06 (4.12.0)
Java version: 1.8.0_212
Operating System: Windows 10 OS
Selenium Web Driver Version: selenium-java-3.141.59
TestNg: 7.0.0-beta1.jar
Chrome version 80 >> ChromeDriver 80.0.3987.16
```

### Instructions:

A step by step process that tell you how to run the Selenium Web Driver UI tests.

```
1. Import the 'adeptotest' project into Eclispe IDE.
2. Under the package explorer navigate to 'testng.xml'
3. Right click on 'testng.xml' file > Run As > TestNG Suite
4. TestNg will start running the Selenium Web Driver tests.
5. At the end of the test run, it will create a screenshot in jpg format and copy that to..\adeptotest folder.
6. To see the test results - Expand the 'test-output' folder under package explorer, right click on 'emailable-report.html' > open it with Web Browser.

```

## Running the tests

Couple of ways you can run the UI test. 

* Right click on 'testng.xml' file > Run As > TestNG Suite
* Running executable jar from the CLI, ex: java -jar selenium-server.jar -htmlSuite "*firefox" "http://ip_address" "C:\mytestsuite\mytestsuite.html"  "C:\mytestsuite\results.html"
  

### Break down into end to end tests

Explain what these tests test and why

```
Automation UI tests are created for Sign Up module. These UI tests will ensure better feedback, stability about the module 
and ensure system is performing necessary validations at all times.

```

### And coding style tests

Explain what these tests and why

```
Automation UI tests are created in Page Object Model. This pattern provide better modularity, easy to maintain, redability and avoid code duplication.
```

## Authors

* **Vinod M** - *Initial work* - [PurpleBooth](https://github.com/scrumvisualize)


## Note

* Chrome driver is located under resources folder "..\adeptotest\resources"


