package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.GooglePage;
import utilities.Driver;
import utilities.config.Config;
import utilities.config.ConfigEnv;

public class NavigateP {

    WebDriver driver = Driver.getDriver();
    GooglePage googlePage = new GooglePage(driver);


    @Given("user navigate the {string} search")
    public void user_navigate_the_search(String url) {
        driver.get(url);
    }

    @When("user put in the search box {string} and click the bottom")
    public void user_put_in_the_search_box_and_click_the_bottom(String value) throws InterruptedException {

        googlePage.searchBox.sendKeys(ConfigEnv.getProperty(value));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click()",googlePage.searchBox);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(3000);
        googlePage.clickLink(ConfigEnv.getProperty(value),driver);
        Thread.sleep(1000);
        javascriptExecutor.executeScript("arguments[0].click()",googlePage.playButton);
        Thread.sleep(5000);
//        driver.quit();
    }

    @Given("check invironment")
    public void check_invironment() {

        System.out.println(ConfigEnv.getProperty("test"));
//        driver.close();
    }

}
