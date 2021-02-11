package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@aria-label='Play (k)']")
    public WebElement playButton;

    public void clickLink(String url, WebDriver driver){

        String xpathUrl = "//a[contains(@href,'"+url+"')]";
        WebElement el = driver.findElement(By.xpath(xpathUrl));
        el.click();
    }
}


