package StepsDef;

import GoBear.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.concurrent.TimeUnit;

public class assignment2Steps extends BasePage {

    By linkInsurance = By.xpath("//a[@href='#Insurance']");
    By linkTravel = By.xpath("//a[@href='#Travel']");
    By btnShowMyResults = By.xpath("//button[@name='product-form-submit']");
    By radioPromosOnly = By.xpath("//label[contains(text(),'Promos only')]");
    By radioShowAll = By.xpath("//label[contains(text(),'Show all')]");
    By btnSeeMore = By.xpath("//a[@class='btn-ripple more']");
    By btnSeeLess = By.xpath("//a[@class='btn-ripple less']");

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

    @When("^I want to result page display Promotion: (.*)$")
    public void select_promotion_type(String type) throws Exception {
        if (type.trim().equalsIgnoreCase("show all"))
            clickOn(radioShowAll);
        else if (type.trim().equalsIgnoreCase("promos only"))
            clickOn(radioPromosOnly);
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

    @When("^I want to select INSURERS: (.*)$")
    public void select_insurers_by(String insurers) throws Exception {
        //TODO: add handle for multiple insurer selected

        By insurerCheckbox = By.xpath("//label[contains(text(),'"+ insurers + "')]");
        clickOn(insurerCheckbox);
    }

    @When("^I want to select SORT option (.*)$")
    public void select_sort_by(String sortBy) throws Exception {
        By insurerCheckbox = By.xpath("//label[contains(text(),'"+ sortBy + "')]");
        clickOn(insurerCheckbox);
    }

    @When("^I want to select DETAILS option POLICY TYPE=(.*), Who's going=(.*), Destination=(.*)$")
    public void select_details_by(String details,String person, String dest) throws Exception {
        By insurerCheckbox = By.xpath("//label[contains(text(),'"+ details + "')]");
        clickOn(insurerCheckbox);
    }

    @When("^Select travel date from = (.*)$")
    public void select_date_by(String date) throws Exception {
        Thread.sleep(3000);
        String [] temp = date.split("-");
        temp[0] = Integer.valueOf(temp[0]).toString(); //return single number if day < 10 (e.g. 06 -> 6)
        By dateFrom = By.xpath("//div[@class='date-from']");
        clickOn(dateFrom);

        Thread.sleep(2000); //wait for DatePicker
        By day = By.xpath("//td[(@class='day' or @class='range day') and text()='" + temp[0] + "']");
        clickOn(day);
    }

    @When("^Select Destination: (.*)$")
    public void select_dropdown_list(String item) throws Exception {
        Thread.sleep(3000);
        RemoteWebElement destinationOne = (RemoteWebElement) driver.findElement((By.xpath("//div[@class='select-component']")));
        clickOn(destinationOne);

        Thread.sleep(1000);
        JavascriptExecutor js =  driver;
        js.executeScript("window.scrollTo(0, 700)"); // to display whole list

        Thread.sleep(1000); //wait for element to be load
        clickOn(By.xpath("//a/span[text()='" + item + "']/following-sibling::link"));
    }

    @When("^Slide the bar (.*) to (.*) percent$")
    public void close_browser(String name, int percent) throws Exception {
        Thread.sleep(3000);
        WebElement minPoint = driver.findElement(By.xpath("//label[contains(text(),'" + name.trim() + "')]/following-sibling::div/div/div[@class='slider-handle min-slider-handle round']"));
        WebElement sliderTrack = driver.findElement(By.xpath("//label[contains(text(),'" + name.trim() + "')]/following-sibling::div/div"));
        int trackLength = sliderTrack.getSize().width;
        new Actions(driver).dragAndDropBy(minPoint,trackLength*percent/100,0).perform();

    }

    @When("^Close browser$")
    public void close_browser() throws Exception {
        closeDriver();
    }

    @When("^Wait for (.*) seconds$")
    public void close_browser(int sec) throws Exception {
        Thread.sleep(sec*1000);
    }

    @When("^I want to extend for more options in filter$")
    public void extend_filter() throws Exception {
        clickOn(btnSeeMore);

    }

    @Then("^Verify summary text at the top should display: (.*)$")
    public void verify_text_topSummary_contain(String text) throws Exception {
        Thread.sleep(3000);
        assert driver.findElement(By.xpath("//p/small")).getText().toLowerCase().contains(text.toLowerCase().trim());
    }

    @Then("^Verify the price is sorted by (.*)$")
    public void verify_list(String byOrder) throws Exception {
        // byOrder = ["high to low",
        //              "low to high"]
        Thread.sleep(5000);

        //get all offers, continue to compare if quantity of offer > 1
        int totalOffer = driver.findElements(By.xpath("//div[@class='policy-price']/span")).size();
        System.out.println("Total offers: " + totalOffer);
        if (totalOffer > 1) {
            for (int i = 1; i < totalOffer; i++) {
                float value1 = Float.valueOf(driver.findElement(By.xpath("(//div[@class='policy-price']/span)[" + i + "]")).getText().replace(",", ""));
                System.out.println(i + ":" + value1);
                float value2 = Float.valueOf(driver.findElement(By.xpath("(//div[@class='policy-price']/span)[" + (i + 1) + "]")).getText().replace(",", ""));
                System.out.println(i + 1 + ":" + value2);
                if (byOrder.trim().equalsIgnoreCase("high to low"))
                    assert value1 >= value2;
                else
                    assert value1 <= value2;
            }
        }
    }


    @Then("^Verify coverage score is sorted by (.*)$")
    public void verify_coverage_score_order(String byOrder) throws Exception {
        // byOrder = ["high to low",
        //              "low to high"]
        Thread.sleep(5000);

        //get all offers, continue to compare if quantity of offer > 1
        int totalOffer = driver.findElements(By.xpath("//div[@class='policy-price']")).size();
        System.out.println("Total offers: " + totalOffer);
        if (totalOffer > 1) {
            for (int i = 1; i < totalOffer; i++) {
                float value1 = Float.valueOf(driver.findElement(By.xpath("(//div[@class='coverage-score'])[" + i + "]")).getText().replace(".", "").replace(" / ",""));
                System.out.println(i + ":" + value1);
                float value2 = Float.valueOf(driver.findElement(By.xpath("(//div[@class='coverage-score'])[" + (i + 1) + "]")).getText().replace(".", "").replace(" / ",""));
                System.out.println(i + 1 + ":" + value2);
                if (byOrder.trim().equalsIgnoreCase("high to low"))
                    assert value1 >= value2;
                else
                    assert value1 <= value2;
            }
        }
    }


    @Then("^Verify review score is sorted by (.*)$")
    public void verify_review_score_order(String byOrder) throws Exception {
        // byOrder = ["high to low",
        //              "low to high"]
        Thread.sleep(5000);

        //get all offers, continue to compare if quantity of offer > 1
        int totalOffer = driver.findElements(By.xpath("//div[@class='policy-price']")).size();
        System.out.println("Total offers: " + totalOffer);
        if (totalOffer > 1) {
            for (int i = 1; i < totalOffer; i++) {
                float value1 = Float.valueOf(driver.findElement(By.xpath("(//div[@class='rating'])[" + i + "]")).getAttribute("data-review-score"));
                System.out.println(i + ":" + value1);
                float value2 = Float.valueOf(driver.findElement(By.xpath("(//div[@class='rating'])[" + (i + 1) + "]")).getAttribute("data-review-score"));
                System.out.println(i + 1 + ":" + value2);
                if (byOrder.trim().equalsIgnoreCase("high to low"))
                    assert value1 >= value2;
                else
                    assert value1 <= value2;
            }
        }
    }


    @Then("^Verify cards are sorted by (.*)$")
    public void verify_insurer_order(String byOrder) throws Exception {
        // byOrder = ["A to Z",
        //              "Z to A"]
        Thread.sleep(5000);

        //get all offers, continue to compare if quantity of offer > 1
        int totalOffer = driver.findElements(By.xpath("//div[@class='policy-price']")).size();
        System.out.println("Total offers: " + totalOffer);
        if (totalOffer > 1) {
            for (int i = 1; i < totalOffer; i++) {
                String insureName = driver.findElement(By.xpath("(//h4)[" + i + "]")).getText();
                System.out.println(i + ":" + insureName);
                String insureName2 = driver.findElement(By.xpath("(//h4)[" + (i + 1) + "]")).getText();
                System.out.println(i + 1 + ":" + insureName2);
                if (byOrder.trim().equalsIgnoreCase("a to z"))
                    assert (insureName.toLowerCase().compareTo(insureName2.toLowerCase()) <= 0);
                else
                    assert (insureName.toLowerCase().compareTo(insureName2.toLowerCase()) >= 0);
            }
        }
    }


    @Then("^The result page should display (.*) (.*) card\\(s\\)$")
    public void check_quantity_of_cards_displayed(String math_operator, int quantity) throws Exception {
        //*math_operator = [less_than,
//                          greater_than,
//                          equal]
        // TODO: should wait for ajax complete
        Thread.sleep(3000);

        By cards = By.xpath("//div[@class='card-wrapper']");
        int totalOffer = driver.findElements(cards).size();
        System.out.println("Total offers: " + totalOffer);
        System.out.println("Number to be compare: " + quantity);

        switch (math_operator.toLowerCase().trim()){
            case "less_than":
                assert totalOffer < quantity ;
                break;
            case "greater_than":
                assert totalOffer > quantity ;
                break;
            case "equal":
                assert totalOffer == quantity ;
                break;
        }
    }

    By addMoraDestination = By.xpath("//a[@class='add-field']");
    By removeDestination = By.xpath("//a[@class='fa fa-minus-circle']");
    @When("^I want to (.*) (.*) Destination$")
    public void add_more_destination(String add_remove, int quantity) throws Exception {
        if (add_remove.equalsIgnoreCase("add"))
            do {
//                driver.executeScript("arguments[0].scrollIntoView(true);", (WebElement)addMoraDestination);
                clickOn(addMoraDestination);
                quantity--;
                Thread.sleep(1000);
            }while (quantity > 0);
        else if (add_remove.equalsIgnoreCase("remove")) {
            do {
                clickOn(removeDestination);
                quantity--;
                Thread.sleep(1000);
            }while (quantity > 0);
        }
    }


    @Then("^I should see there are total (.*) destinations$")
    public void verify_total_destination(int quantity) throws Exception {
        Thread.sleep(3000);
        assert driver.findElements(By.xpath("//div[@class='select-component']/button")).size()== quantity;
    }

    @When("^I want to select number of person for the trip: (.*)")
    public void select_number_person(String quantity) throws Exception {
        By noOfPerson = By.xpath("//label[contains(text(),'"+ quantity + "')]");
        clickOn(noOfPerson);
    }

    @When("^I want to select POLICY TYPE=(.*)$")
    public void select_policy_type(String type) throws Exception {
        By radioPolicyType = By.xpath("//label[contains(text(),'"+ type + "')]");
        clickOn(radioPolicyType);
    }
}
