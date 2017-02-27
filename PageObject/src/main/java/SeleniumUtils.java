import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by RXC8414 on 2/21/2017.
 */
public class SeleniumUtils{
    public WebDriver driver;

    public SeleniumUtils(){
        //String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", path);
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitUntilElementDisplayed(By expression){
        int counter = 0;
        do {
            if (verifyDisplayed(expression)){
                return true;
            }
            else if (counter > 3){
                if(verifyEnabled(expression)){
                    return true;
                }

                else if (verifyLocation(expression)){
                    return true;
                }
            }

            counter++;
            try {
                TimeUnit.MILLISECONDS.sleep(950);
            }catch(Exception e){
                return false;
            }
        } while (counter < 10);

        return false;
    }

    public boolean waitUntilElementDisplayed(WebElement expression){
        int counter = 0;
        do {
            if (verifyDisplayed(expression)){
                return true;
            }
            else if (counter > 3){
                if(verifyEnabled(expression)){
                    return true;
                }

                else if (verifyLocation(expression)){
                    return true;
                }
            }

            counter++;
            try {
                TimeUnit.MILLISECONDS.sleep(950);
            }catch(Exception e){
                return false;
            }
        } while (counter < 10);

        return false;
    }

    public boolean verifyDisplayed(By expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (driver.findElement(expression).isDisplayed()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyDisplayed(WebElement expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (expression.isDisplayed()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyEnabled(By expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (driver.findElement(expression).isEnabled()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyEnabled(WebElement expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (expression.isEnabled()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyLocation(By expression){
        try{
            TimeUnit.MILLISECONDS.sleep(50);
            if(driver.findElement(expression).getLocation().x < 0 ||
                    driver.findElement(expression).getLocation().y < 0){
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyLocation(WebElement expression){
        try{
            TimeUnit.MILLISECONDS.sleep(50);
            if(expression.getLocation().x < 0 ||
                    expression.getLocation().y < 0){
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean navigateURL(String url, By element){
        driver.get(url);
        if(waitUntilElementDisplayed(element)){
            return true;
        }
        return false;
    }

    public boolean navigateURL(String url, WebElement element){
        driver.get(url);
        if(waitUntilElementDisplayed(element)){
            return true;
        }
        return false;
    }



    public boolean addStringToTextBox(String strText, By element){
        try {
            if (waitUntilElementDisplayed(element)) {
                driver.findElement(element).clear();
                driver.findElement(element).sendKeys(strText);
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean addStringToTextBox(String strText, WebElement element){
        try {
            if (waitUntilElementDisplayed(element)) {
                element.clear();
                element.sendKeys(strText);
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean clickButton(By element){
        try{
            if(waitUntilElementDisplayed(element)){
                driver.findElement(element).click();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean clickButton(WebElement element){
        try{
            if(waitUntilElementDisplayed(element)){
                element.click();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }


    public boolean verifyLandingPage(By landingPage){
        try{
            if(waitUntilElementDisplayed(landingPage)){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean verifyLandingPage(WebElement landingPage){
        try{
            if(waitUntilElementDisplayed(landingPage)){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }


    public String getPageText(By element){
        if(waitUntilElementDisplayed(element)){
            return driver.findElement(element).getText();
        }
        return null;
    }

    public String getPageText(WebElement element){
        if(waitUntilElementDisplayed(element)){
            return element.getText();
        }
        return null;
    }

    public boolean closeWindows(By elementWin, By element, By landingPage){
        if(waitUntilElementDisplayed(elementWin)){
            if(waitUntilElementDisplayed(element)){
                driver.findElement(landingPage).click();
                if(waitUntilElementDisplayed(landingPage)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean closeWindows(WebElement elementWin, WebElement element, WebElement landingPage){
        if(waitUntilElementDisplayed(elementWin)){
            if(waitUntilElementDisplayed(element)){
                landingPage.click();
                if(waitUntilElementDisplayed(landingPage)){
                    return true;
                }
            }
        }
        return false;
    }

    public List<WebElement> getElements(By wrapper){
        try{
            List<WebElement> list = driver.findElements(wrapper);
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<WebElement> getElements(List<WebElement> wrapper){
        try{
            List<WebElement> list = wrapper;
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void waitSeconds(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void clearField(WebElement element, By field){
        try{
            element.findElement(field).clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeDriver(){
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
