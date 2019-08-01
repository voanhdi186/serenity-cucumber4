import GoBear.BasePage;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/features",
        glue = "StepsDef",
        tags = "@verify-filter-option"
)
public class CucumberTestSuite {
    static BasePage basePage;

    public CucumberTestSuite(){

    }

    @BeforeClass
    public static void setUp(){
        basePage = new BasePage();

    }

//    @AfterClass
//    public static void tearDown(){
//        basePage.closeDriver();
//
//    }
}
