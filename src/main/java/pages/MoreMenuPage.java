package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MoreMenuPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="logout_sidebar_link")
    WebElement logoutBtn;

    public MoreMenuPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void clickLogoutBtn() {
        wait.until(ExpectedConditions.visibilityOf(logoutBtn)).click();
    }
}
