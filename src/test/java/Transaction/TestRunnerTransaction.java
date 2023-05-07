package Transaction;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Transaction", glue= {"Transaction"}, 
monochrome =true,
plugin = {"pretty", "html:target/HtmlReports/ReportTransaction.html",
		"json:target/JSONReports/ReportTransaction.json",
		"junit:target/JunitReports/ReportTransaction.xml"},
tags = "@AddOrder" 
		)
public class TestRunnerTransaction{
	
}