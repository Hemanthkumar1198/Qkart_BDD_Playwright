package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/QkartTesting.feature", 
				glue = { "stepdefintion", "hooks" }, 
				plugin = { "pretty", "html:target/Testreport.html",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
				monochrome = true)
public class Testrunner extends AbstractTestNGCucumberTests {

}
