package StepsDef;

import GoBear.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class assignment2 extends BasePage {

    By linkInsurance = By.xpath("//a[@href='#Insurance']");
    By linkTravel = By.xpath("//a[@href='#Travel']");
    By btnShowMyResults = By.xpath("//button[@name='product-form-submit']");

    @Given("^Open browser and start with url (.*)$")
    public void start_with_url(String url) throws Exception {
        System.out.println("Start Chrome driver");
        System.setProperty("webdriver.chrome.driver","src/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("^Navigate to (.*) section$")
    public void navigate_to_travel(String places) throws Exception {
        clickOn(linkInsurance);
        clickOn(linkTravel);
    }

    @When("^I am looking for (.*) travel plans for (.*) person\\(s\\). I am going to (.*).$")
    public void enter_criterias_part_one(String kindOfTrip, String noOfPerson, String destination) throws Exception {
        //TODO: TBD

        By destinationName = By.xpath("//span[text()='" + destination + "']");

        // select travel plane
        if (kindOfTrip.equalsIgnoreCase("annual trip"))
//            clickOn();
            ;

        //select number of person
        switch (noOfPerson.toLowerCase()) {
            case "my family":
//                clickOn();
                break;
            case "2 persons":
//                clickOn();
                break;

            default:
        }

        //select travel destination
        if (destination.equalsIgnoreCase(""))
//            selectItem(destinationName);
            ;
    }


    @When("^from (.*) to (.*)$")
    public void enter_criterias_part_two(String fromDate, String toDate) throws Exception {
        selectDate(fromDate);
        selectDate(toDate);
    }

    @When("^I click on button: (.*)$")
    public void click_on_button_text(String buttonText) throws Exception {
//        clickOnButtonHasText(buttonText);
        By btnShowResult = By.xpath("//button[text()='Show my results']");
        clickOn(btnShowResult);

    }

    @When("^Scroll down the page$")
    public void scroll_down() throws Exception {
//        clickOnButtonHasText(buttonText);
//        By btnShowResult = By.xpath("//button[text()='Show my results']");
//        clickOn(btnShowResult);

    }

    @When("^I want to select INSURERS: (.*)")
    public void select_insurers(String insurers) throws Exception {
        //TODO: add handle for multiple insurer selected

        By insurerCheckbox = By.xpath("//label[contains(text(),'"+ insurers + "')]");
        clickOn(insurerCheckbox);
    }

    @Then("^The result page should display (.*) (.*) card\\(s\\)$")
    public void check_quantity_of_cards_displayed(String math_operator, String quantity) throws Exception {
        // TODO: should wait for ajax complete
        Thread.sleep(3000);

        By cards = By.xpath("//div[@class='card-wrapper']");
        switch (math_operator.toLowerCase().trim()){
            case "less than":
                assert driver.findElements(cards).size() <= Integer.valueOf(quantity) ;
            case "more than":
                assert driver.findElements(cards).size() >= Integer.valueOf(quantity) ;
            case "equal":
                assert driver.findElements(cards).size() == Integer.valueOf(quantity) ;
        }
    }





}
