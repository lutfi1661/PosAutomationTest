package Category;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/Category",
		glue={"Category"},
		monochrome =true,
		plugin = {
				"pretty", "html:target/HtmlReports/Report.html",
			"json:target/JSONReports/report.json",
			"junit:target/JunitReports/report.xml"
		},
		//tags = "@NavPageCat"
//		tags = "@AddCategory"
		tags = "@EditCategory"

		)
public class TestRunner {

}
