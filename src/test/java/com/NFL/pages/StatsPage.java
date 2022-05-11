package com.NFL.pages;

import com.NFL.utilities.BrowserUtils;
import com.NFL.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StatsPage extends BasePage {

    @FindBy(xpath = "//select[@class='d3-o-dropdown']")
    public WebElement yearDropDown;

    @FindBy(xpath = "//th")
    public List<WebElement> listOfStatsType;

    @FindBy(xpath = "//tr[1]/td[1]")
    public WebElement highestPlayer;

    @FindBy(xpath = "//tr")
    public List<WebElement> playerList;

    @FindBy(xpath = "//th[normalize-space()='Player']")
    public WebElement playerColumn;

    public void clickOnStatsCategory(String categoryName) {
        Driver.get().findElement(By.xpath("//a[normalize-space()='" + categoryName + "']")).click();
    }

    public void selectYear(String year) {
        Select dropdown = new Select(yearDropDown);
        dropdown.selectByVisibleText(year);

    }

    public void clickOnStatsType(String statsType) {
        Driver.get().findElement(By.xpath("//a[normalize-space()='" + statsType + "']")).click();
    }

    public String getHighestValue(String statsType) {
        String indexOfStatsType = String.valueOf(BrowserUtils.getElementsText(listOfStatsType).indexOf(statsType) + 1);
        return Driver.get().findElement(By.xpath("//tr[1]/td[" + indexOfStatsType + "]")).getText();

    }

    public String getLowestPlayer() {
        String indexOfLastPlayer = String.valueOf(BrowserUtils.getElementsText(playerList).size() - 1);
        return Driver.get().findElement(By.xpath("//tr[" + indexOfLastPlayer + "]/td")).getText();


    }

    public String getLowestValue(String statsType) {
        String indexOfStatsType = String.valueOf(BrowserUtils.getElementsText(listOfStatsType).indexOf(statsType) + 1);
        String indexOfLastPlayer = String.valueOf(BrowserUtils.getElementsText(playerList).size() - 1);
        return Driver.get().findElement(By.xpath("//tr[" + indexOfLastPlayer + "]/td[" + indexOfStatsType + "]")).getText();

    }


}
