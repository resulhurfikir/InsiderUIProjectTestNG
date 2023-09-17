package Pages;

import Utilities.ConfigurationReader;
import Utilities.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualityAssurancePage extends Methods {

    public QualityAssurancePage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(linkText = "See all QA jobs")
    private WebElement allJobs;

    public void navigateToQualityAssurancePage(){
        getDriver().navigate().to(ConfigurationReader.getProperty("qualityAssuranceUrl"));
    }

    public void clickAllJobsButton(){
        clickFunction(allJobs);
    }

}
