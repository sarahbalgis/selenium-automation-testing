package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondPage extends BasePage {

    public SecondPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='NotifyZwayam']")
    WebElement firstMail;

    @FindBy(xpath = "//div[contains(text(), '[Reminder] Review Request Pending')]")
    WebElement txtGetSubject;


    public void switchToIframeInbox(String ifInboxElement) {
        driver.get().switchTo().frame(ifInboxElement);
    }

    public void clickFirstMail() {
        clickAndWait(firstMail);
    }

    public void switchToIframeMail(String ifMailElement) {
        driver.get().switchTo().frame(ifMailElement);
    }

    public void switchToDefaultContent() {
        driver.get().switchTo().defaultContent();
    }

    public String getMailText() {
        return getText(txtGetSubject);
    }
}
