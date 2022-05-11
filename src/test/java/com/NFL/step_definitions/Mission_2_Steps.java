package com.NFL.step_definitions;

import com.NFL.pages.HomePage;
import com.NFL.pages.StatsPage;
import com.NFL.utilities.BrowserUtils;
import com.NFL.utilities.ConfigurationReader;
import com.NFL.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;

public class Mission_2_Steps {
    //creates an object from related classes to work on
    HomePage homePage = new HomePage();
    StatsPage statsPage = new StatsPage();

    @Given("the user is on the home page")
    //navigates to homepage with using Configuration Reader class
    public void the_user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("the user clicks on {string} tab")
    public void the_user_clicks_on_tab(String tabName) {
        //navigates to header tab with the given tabName
        homePage.laterButton.click();
        homePage.clickOnTab(tabName);
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String categoryName) {
        //navigates to sub stats tab with the given categoryName
        statsPage.clickOnStatsCategory(categoryName);

    }

    @And("the user selects {string} as a year")
    public void theUserSelectsAsAYear(String year) {
        //selects a year with the given year
        BrowserUtils.waitForVisibility(statsPage.yearDropDown, Duration.ofMillis(2000));
        statsPage.selectYear(year);

    }

    @Then("the user should see {string} as highest on {string} with {string} value")
    public void theUserShouldSeeAsHighestOnWithValue(String expectedPlayerName, String statsType, String expectedValue) {
        //clicks on the related stats type with the given statsType
        statsPage.clickOnStatsType(statsType);
        BrowserUtils.waitForVisibility(statsPage.playerColumn, Duration.ofMillis(2000));
        //verifies that expected and actual information are same
        Assert.assertEquals(expectedPlayerName, statsPage.highestPlayer.getText());
        Assert.assertEquals(expectedValue, statsPage.getHighestValue(statsType));
        //prints the result as expected
        System.out.println("Highest " + statsType + " player: " + statsPage.highestPlayer.getText() + " with value: " + statsPage.getHighestValue(statsType));


    }

    @Then("the user should see {string} as lowest on {string} with {string} value")
    public void theUserShouldSeeAsLowestOnWithValue(String expectedPlayerName, String statsType, String expectedValue) {
        //verifies that expected and actual information are same
        Assert.assertEquals(expectedPlayerName, statsPage.getLowestPlayer());
        Assert.assertEquals(expectedValue, statsPage.getLowestValue(statsType));
        //prints the result as expected
        System.out.println("Lowest " + statsType + " player: " + statsPage.getLowestPlayer() + " with value: " + statsPage.getLowestValue(statsType));

    }
}
