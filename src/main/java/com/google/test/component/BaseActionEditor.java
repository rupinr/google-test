package com.google.test.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseActionEditor {

    protected WebDriver driver;


    public BaseActionEditor(WebDriver driver) {
        this.driver = driver;
    }

    public void editTextFieldById(String id, String text) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(text);
    }


    public void moveToElementAndClickByName(String name){
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.name(name)))
                .click()
                .build()
                .perform();
    }
    public void clickOnElementById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void clickOnElementByName(String name) {
        driver.findElement(By.name(name)).click();
    }

    public void clickOnElementByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void selectComboBoxByIdWithValue(String id, String value) {
        Select select = new Select(this.driver.findElement(By.id(id)));
        select.selectByValue(value);
    }

    public void selectComboBoxByIdWithText(String id, String text) {
        Select select = new Select(this.driver.findElement(By.id(id)));
        select.selectByVisibleText(text);
    }

    public String getElementTextByXpath(String xpath){
        return this.driver.findElement(By.xpath(xpath)).getText();
    }

    public String getInputFieldTextById(String id){
        return this.driver.findElement(By.id(id)).getAttribute("value");
    }


}
