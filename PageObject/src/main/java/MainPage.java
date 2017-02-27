import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by RXC8414 on 2/21/2017.
 */
public class MainPage extends SeleniumUtils{

    WebDriver driver;

    By headerSearch = By.xpath(".//input[@id='headerSearch']");
    //By headerSearchButton = By.xpath(".//button[@id='headerSearchButton']");

    //@FindBy(xpath = ".//input[@id='headerSearch']")
    //WebElement headerSearch;

    @FindBy(xpath = ".//button[@id='headerSearchButton']")
    WebElement headerSearchButton;

    public MainPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean verifyCanSearchByItem(String item){
        if(addStringToTextBox(item,headerSearch)){
            if(clickButton(headerSearchButton)){
                return true;
            }
        }
        return false;
    }
}
