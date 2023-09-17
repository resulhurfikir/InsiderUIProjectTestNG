package Pages;

import Utilities.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OpenPositionsPage extends Methods {

    public OpenPositionsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "select2-filter-by-location-container")
    private WebElement locationFilter;
    @FindBy(id = "select2-filter-by-department-container")
    private WebElement departmentFilter;
    @FindBy(xpath = "//li[text()='Istanbul, Turkey']")
    private WebElement istanbulTurkey;
    @FindBy(css = "[class='position-list-item-wrapper bg-light']>span")
    private List<WebElement> jobTitles;
    @FindBy(css = "[class='position-list-item-wrapper bg-light']>div")
    private List<WebElement> jobLocations;
    @FindBy(css = "[class='position-list-item-wrapper bg-light']>a")
    private WebElement viewRoleButton;


    public void chooseLocation() {
        scrollToElement(departmentFilter);
        waitUntilAttributeContains(departmentFilter, "title", "Assurance");
        clickFunction(locationFilter);
        clickFunction(istanbulTurkey);
    }

    public void assertJobsRelatedFiltering() {
        scrollToElement(jobTitles.get(0));
        waitForStale();
        for (WebElement we : jobTitles) {
            Assert.assertEquals(we.getText(),"Quality Assurance");
            }

        for(WebElement we : jobLocations) {
        Assert.assertEquals(we.getText(),"Istanbul, Turkey");
        }
    }


    public void clickViewRole() {
        jsClickFunction(viewRoleButton);
    }
}
