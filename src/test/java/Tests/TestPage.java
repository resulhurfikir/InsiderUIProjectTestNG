package Tests;

import Utilities.BaseClass;
import org.testng.annotations.*;

public class TestPage extends BaseClass {

    @Test
    public void test(){
    homePage.navigateToHomePageAndCloseCookie();
    homePage.assertHomePageIsOpen();
    homePage.selectCompany();
    homePage.selectCareers();
    careersPage.assertSomeInsiderBlocksAreOpen();
    qualityAssurancePage.navigateToQualityAssurancePage();
    qualityAssurancePage.clickAllJobsButton();
    openPositionsPage.chooseLocation();
    openPositionsPage.assertJobsRelatedFiltering();
    openPositionsPage.clickViewRole();
    applicationPage.assertPageOpenedSuccessfully();
    }
}
