package Product;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Product", glue={"Product"}, 
monochrome =true, 
plugin = {"pretty", "html:target/reports/cucumber.html",
		"json:target/reports/cucumber.json",
		"junit:target/reports/cucumber.xml"},
tags = "@NavPageProd"
		)
public class TestRunner {

}
