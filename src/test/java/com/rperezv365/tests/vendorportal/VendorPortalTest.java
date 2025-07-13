package com.rperezv365.tests.vendorportal;

import com.rperezv365.pages.vendorportal.DashBoardPage;
import com.rperezv365.pages.vendorportal.LoginPage;
import com.rperezv365.tests.AbstractTest;
import com.rperezv365.tests.vendorportal.model.VendorPortalTestData;
import com.rperezv365.util.Config;
import com.rperezv365.util.Constants;
import com.rperezv365.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * VendorPortalTest
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 29/06/2025 - 11:54
 * @since 1.17
 */
public class VendorPortalTest extends AbstractTest {

    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters({"testDataPath"})
    public void setPageObjects(String testDataPath) {
        this.loginPage = new LoginPage(driver);
        this.dashBoardPage = new DashBoardPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, VendorPortalTestData.class);
    }

    @Test
    public void loginTest() {
        loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.username(), testData.password());
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest() {
        Assert.assertTrue(dashBoardPage.isAt());

        // financial metrics
        Assert.assertEquals(dashBoardPage.getMonthlyEarning(), testData.monthlyEarning());
        Assert.assertEquals(dashBoardPage.getAnnualEarning(), testData.annualEarning());
        Assert.assertEquals(dashBoardPage.getProfitMargin(), testData.profitMargin());
        Assert.assertEquals(dashBoardPage.getAvailableInventory(), testData.availableInventory());

        // order registry search
        dashBoardPage.searchOrderHistoryBy(testData.searchKeyword());
        Assert.assertEquals(dashBoardPage.getSearchResultsCount(), testData.searchResultsCount());
    }

    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest() {
        // logout
        dashBoardPage.logout();
        Assert.assertTrue(loginPage.isAt());
    }

}
