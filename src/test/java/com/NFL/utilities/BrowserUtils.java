package com.NFL.utilities;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BrowserUtils {

    /**class which includes utils that can be used in whole project*/

    /**
     * return a list of string from a list of elements
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /**
     * Waits for the provided element to be visible on the page
     */
    public static void waitForVisibility(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}