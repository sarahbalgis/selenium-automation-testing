package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SecondPage;
import page.FirstPage;
import utilities.Utility;

public class YopmailTest extends BaseTest {

    @Test
    public void verifySubjectMailSuccess() {
        FirstPage firstPage = new FirstPage(driver, explicitWait);
        SecondPage secondPage = new SecondPage(driver, explicitWait);

        firstPage.searchMail("automationtest");

        secondPage.switchToIframeInbox("ifinbox");

        secondPage.clickFirstMail();

        secondPage.switchToDefaultContent();

        secondPage.switchToIframeMail("ifmail");

        String txtExpectedSubjectMail = "[Reminder] Review Request Pending";

        System.out.println("Verification passed! Mail subject is as expected.");
        System.out.println("Expected Subject: " + txtExpectedSubjectMail);
        System.out.println("Actual Subject: " + secondPage.getMailText());

        Assert.assertEquals(secondPage.getMailText(), txtExpectedSubjectMail,
                "Verification failed! Mail subject is not as expected.");

        Utility.hardWait(2);

    }

    @Test
    public void verifySubjectMailFailed() {
        FirstPage firstPage = new FirstPage(driver, explicitWait);
        SecondPage secondPage = new SecondPage(driver, explicitWait);

        firstPage.searchMail("automationtest");

        secondPage.switchToIframeInbox("ifinbox");

        secondPage.clickFirstMail();

        secondPage.switchToDefaultContent();

        secondPage.switchToIframeMail("ifmail");

        String txtExpectedSubjectMail = "Failed Subject";

        System.out.println("Verification failed! Text is not as expected.");
        System.out.println("Expected Text: " + txtExpectedSubjectMail);
        System.out.println("Actual Text: " + secondPage.getMailText());

        Assert.fail("Verification failed! Text is not as expected.");

        secondPage.switchToDefaultContent();

        Utility.hardWait(2);

    }
}