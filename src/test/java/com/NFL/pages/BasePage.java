package com.NFL.pages;

import com.NFL.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
    //consists of common elements and methods for all pages excepts home page
    //it is abstract to be extended by page classes and could not to be instantiated
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void clickOnTab(String tabName) {
        Driver.get().findElement(By.xpath("//span[normalize-space()='" + tabName + "']")).click();
    }
}
