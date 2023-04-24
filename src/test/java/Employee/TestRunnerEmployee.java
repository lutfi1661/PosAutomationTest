package Employee;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Employee", glue= {"Employee"}, 
monochrome =true,
plugin = {"pretty", "html:target/HtmlReports/Report.html",
		"json:target/JSONReports/report.json",
		"junit:raget/JunitReports/report.xml"},
tags = "@AddEmployee, @EditEmployee" 
		)
public class TestRunnerEmployee{
	
}
