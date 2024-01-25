package aut.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = { "aut.stepdef" }, tags = "@aut", plugin = {
		"json:target/reports/cucumber-json-reports/json-report.json",
		"html:target/reports/cucumber-html-reports/html-report.html" })

public class runnerTest extends AbstractTestNGCucumberTests {

}