package Pages;

import Utilities.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;


public class CareersPage extends Methods {

    public CareersPage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(linkText = "See all teams")
    private WebElement allTeams;
    @FindBy(css = "[class='col-12 col-md-6']")
    private WebElement ourLocations;
    @FindBy(xpath = "//*[text()='Life at Insider']")
    private WebElement lifeAtInsider;


    public void assertSomeInsiderBlocksAreOpen(){
        assertTrue(allTeams.isDisplayed());
        assertTrue(ourLocations.isDisplayed());
        assertTrue(lifeAtInsider.isDisplayed());
    }

}
