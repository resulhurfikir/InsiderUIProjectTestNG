package Pages;

import Utilities.ConfigurationReader;
import Utilities.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;

public class HomePage extends Methods{

    public HomePage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "wt-cli-accept-all-btn")
    private WebElement acceptAllButton;
    @FindBy(linkText = "Company")
    private WebElement company;
    @FindBy(linkText = "Careers")
    private WebElement careers;



    public void navigateToHomePageAndCloseCookie(){
        getDriver().get(ConfigurationReader.getProperty("homePageUrl"));
        clickFunction(acceptAllButton);
    }
    public void assertHomePageIsOpen(){
        assertTrue(company.isDisplayed());
    }

    public void selectCompany(){
        clickFunction(company);
    }

    public void selectCareers(){
        clickFunction(careers);
    }


}
