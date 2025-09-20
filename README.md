Run all tests:
mvn clean test

Run single class:
mvn -Dtest=tests.HerokuLoginTest test

Run single method:
mvn -Dtest=tests.HerokuLoginTest#testValidLogin test

Serve Allure report:
mvn allure:serve

Generate Allure report:
allure generate target/allure-results -o target/site/allure-report --clean

Open Allure report:
allure open target/site/allure-report

Run smoke group:
mvn -Dgroups=smoke test

Run regression group:
mvn -Dgroups=regression test

Run specific class/method:
mvn -Dtest="tests.DropdownTest#testDropdownSelections" test
