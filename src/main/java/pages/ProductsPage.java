package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;
    private static final String pageUrl = "https://www.saucedemo.com/inventory.html";
    @FindBy (className="btn_inventory")
    List<WebElement> addToCartBtn;
    @FindBy (className="shopping_cart_badge")
    WebElement cartIcon;
    @FindBy (id = "react-burger-menu-btn")
    WebElement moreMenuIcon;

    public ProductsPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public String getPageUrl() {
        return pageUrl;
    }
    public void addToCart(int product) {
        addToCartBtn.get(product).click();
    }
    public String getCartItemsCount() {
        return cartIcon.getText();
    }
    public void openMoreMenu() {
        moreMenuIcon.click();
    }

}
