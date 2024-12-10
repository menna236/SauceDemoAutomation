package stepdefinitions;
import pages.LoginPage;
import pages.MoreMenuPage;
import pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAddToCartLogoutSteps {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    MoreMenuPage moreMenuPage;

    public LoginAddToCartLogoutSteps() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage= new ProductsPage(driver);
        moreMenuPage=new MoreMenuPage(driver);

    }

    @Given("User navigates to SauceDemo login page")
    public void userNavigatesToLoginPage() {
        driver.get(loginPage.getPageUrl());
    }

    @When("User enters {string} and {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.loginWithCredentials(username,password);
    }

    @Then("User should be redirected to the product page")
    public void userShouldBeRedirectedToProductPage() {
        assertEquals(driver.getCurrentUrl(),productsPage.getPageUrl());
    }

    @Then("An error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        assertTrue(loginPage.isInvalidCredentialsErrMsgDisplayed());
    }

    @Given("User is logged in with {string} and {string}")
    public void userIsLoggedIn(String username ,String password) {
        userNavigatesToLoginPage();
        userEntersCredentials(username,password);
    }

    @When("User adds a product to the cart")
    public void userAddsProductToCart() {
         productsPage.addToCart(1);
    }

    @Then("The cart should contain 1 product")
    public void cartShouldContainOneProduct() {
        assertEquals("1", productsPage.getCartItemsCount());
    }

    @When("User logs out")
    public void userLogsOut() {
        productsPage.openMoreMenu();
        moreMenuPage.clickLogoutBtn();

    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToLoginPage() {
        assertEquals(driver.getCurrentUrl(),loginPage.getPageUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
