package Pages;

import Utilities.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;

public class ApplicationPage extends Methods {
    public ApplicationPage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(className ="postings-btn-wrapper" )
    private WebElement applyButton;

    public void assertPageOpenedSuccessfully(){
        switchNextPage();
        waitUntilClickable(applyButton);
        assertTrue(applyButton.isDisplayed());
    }
}
