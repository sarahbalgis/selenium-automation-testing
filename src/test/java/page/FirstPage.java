package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPage extends BasePage {

    public FirstPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
    }

    @FindBy(id="login")
    WebElement fieldSearchMail;

    public void searchMail(String emailName){
        setText(fieldSearchMail, emailName);
        fieldSearchMail.sendKeys(Keys.ENTER);
    }



}
