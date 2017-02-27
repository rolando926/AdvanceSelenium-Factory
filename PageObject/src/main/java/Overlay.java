import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by RXC8414 on 2/22/2017.
 */
public class Overlay extends LandingPage{
    By overlayTitle = By.xpath(".//span[@class='u__husky' and contains(text(),'Item(s) Added in Cart')]");
    By overlayClose = By.xpath(".//a[@id='atc-continue-shopping']");

    public Overlay(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean verifyOverlay(){
        if(waitUntilElementDisplayed(overlayTitle)){
            if(waitUntilElementDisplayed(overlayClose)){
                if(clickButton(overlayClose)){
                    return true;
                }
            }
        }
        return false;
    }
}
