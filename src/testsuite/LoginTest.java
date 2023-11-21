package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){openBrowser(baseUrl);}
    @Test
    public void userShouldLoginSuccesfullyWithValidCredentials(){
        //finding the Username element and sending the input
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        //finding the Password element and sending the input
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        //finding the login element and clicking on it
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String expectedMessage = "Products";
        //finding the text element from the webpage
        String actualMessage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        //Verify expected and actual message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //finding the Username element and sending the input
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        //finding the Password element and sending the input
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        //finding the login element and clicking on it
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        List<WebElement> noOfProductsDisplayed = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int number = noOfProductsDisplayed.size();
        System.out.println("Number of Products displayed: "+ number);
    }
    @After
    public void closeDown(){closeBrowser();}
    }


