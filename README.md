# appium-challenge

- MOBILE & API Automation Testing Using Java, appium, cucumber and restAssured

### dependencies:
- [appium](https://mvnrepository.com/artifact/io.appium/java-client)
- [cucumber-java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)
- [cucumber-junit](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit)
- [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [hamcrest](https://mvnrepository.com/artifact/org.hamcrest/hamcrest)

### Setting Up
These instructions will get you a copy of the project up and running on your local machine.

- *clone the repo:*
```shell
git clone https://github.com/mahmutkaya/appium-challenge.git
```
- *go to ```configuration.properties``` file - at project level*
- *and add the text below into it with replacing your own values*
```properties
platformName = <platformName>
platformVersion = <platformVersion>
deviceName = <deviceName>
```
- *sdk version: 1.8*

- *And of course do not forget to run the composer* :)

Running tests from terminal:
```shell
mvn -B verify --file pom.xml
```

### About scenarios:
Automated scenarios are:
- CRUD operations of product - api
- Add review - api & ui
- Product details - ui
- Search - ui
- Home screen
