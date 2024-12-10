package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    private static final String pageURl ="https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    WebElement userNameTxtField;
    @FindBy(id = "password")
    WebElement passwordTxtField;
    @FindBy(id = "login-button")
    WebElement LoginBtn;
    @FindBy(className="error-button")
    WebElement errorMsgBtn;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   public String getPageUrl() {
       return pageURl;
    }
    public void enterUserName(String username){
        userNameTxtField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordTxtField.sendKeys(password);
    }
    public void clickLoginBtn(){
        LoginBtn.click();
    }
    public void loginWithCredentials(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginBtn();
    }
    public boolean isInvalidCredentialsErrMsgDisplayed()
    {
        return errorMsgBtn.isDisplayed();
    }
}
