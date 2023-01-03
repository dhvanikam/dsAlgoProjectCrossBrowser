package runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;

@CucumberOptions(plugin = { "pretty", "html:target/dsAlgoReport.html" }, // reporting purpose
		monochrome = false, // console output
		tags = "@TS_array_04", // tags from feature file
		features = { "src/test/resources/features" }, // location of feature files
		glue = { "stepDefinition", "appHooks" }) // location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}
	@BeforeTest
    @Parameters({"browser"})
    public void defineBrowser(String browser) throws Throwable {
		ConfigReader.loadConfig();
		ConfigReader.setBrowserType(browser);
		System.out.println(" in runner " + browser);

}

}