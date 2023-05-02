package Employee;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Employee", glue= {"Employee"}, 
monochrome =true,
plugin = {"pretty", "html:target/HtmlReports/ReportEmployee.html",
		"json:target/JSONReports/ReportEmployee.json",
		"junit:target/JunitReports/ReportEmployee.xml"},
tags = "@AddEmployee, @EditEmployee, " 
		)
public class TestRunnerEmployee{
	
}
