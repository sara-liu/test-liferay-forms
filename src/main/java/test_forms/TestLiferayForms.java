package test_forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLiferayForms {

  public static void testSubmitEmpty(WebDriver driver) {
    WebElement submitButton = driver.findElement(By.id("ddm-form-submit"));
    submitButton.click();
  }

  public static void testSubmitNonEmpty(WebDriver driver) {
    WebElement nameInput = driver.findElement(By.xpath("//input[contains(@name, '_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName')]"));
    nameInput.sendKeys("Liferayer");
    WebElement birthInput = driver.findElement(By.xpath("//input[contains(@placeholder, '__/__/____')]"));
    birthInput.sendKeys("02/20/2020");
    WebElement whyArea = driver.findElement(By.xpath("//textarea[contains(@name, '_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhyDidYouJoinTheTestingArea')]"));
    whyArea.sendKeys("I like testing.");

    WebElement submitButton = driver.findElement(By.id("ddm-form-submit"));
    submitButton.click();
  }

  public static void main(String[] args) throws InterruptedException {
    // Config to the chromedirver path
    System.setProperty("webdriver.chrome.driver", "/Users/saraliu/drivers/chromedriver");
    WebDriver driver = new ChromeDriver();
    String url = "https://forms.liferay.com/web/forms/shared/-/form/122548";
    driver.get(url);

    Thread.sleep(10000);
    testSubmitEmpty(driver);
    Thread.sleep(5000);
    testSubmitNonEmpty(driver);
    Thread.sleep(5000);

    driver.quit();
  }
}
