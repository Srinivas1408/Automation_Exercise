package com.krct;

import com.krct.POMFileTest;
import com.krct.baseTest;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.security.auth.login.AccountExpiredException;
import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class searchEngineTest extends baseTest
{

    @Test(priority = 1)
    public void signupTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h2[contains(text(),'New User Signup')]"))));
        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

//        file.signup("eleven","eleven2026@gmail.com");

        WebElement accountvisible=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[contains(text(),'Enter Account Information')]"))));
        Assert.assertTrue(accountvisible.isDisplayed());

        file.createaccount("abc@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click(); // click Continue

        WebElement loggedelement=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(.,'Logged in as')]"))));
        String logintxt=loggedelement.getText();
        Assert.assertTrue(logintxt.contains("Logged in as"));

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[@href='/delete_account']"))).click(); //click delete button

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-qa='continue-button']"))).click(); // click continue

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]"))).click(); //click logout
    }
    @Test(priority = 2)
    public void loginsucessTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login to your account']"))).isDisplayed();

        file.login("samson2026@gmail.com","abc@123");

        WebElement flash = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(text(),'Logged in as')]")
                )
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]"))).click(); // click logout

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[@href='/delete_account']"))).click(); //click delete

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-qa='continue-button']"))).click(); // click continue
    }
    @Test(priority = 3)
    public void loginFailureTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']"))).click();  //click signup/login

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login to your account']"))).isDisplayed(); //verify login to your account visible or not

        file.login("tvk2026@gmail.com","1234567890");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"))).isDisplayed();
    }
    @Test(priority = 4)
    public void logoutuserTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login to your account']"))).isDisplayed();

        file.login("samson2026@gmail.com","abc@123");

        WebElement flash = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(text(),'Logged in as')]")
                )
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]"))).click(); // click logout

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[@href='/delete_account']"))).click(); //click delete

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-qa='continue-button']"))).click(); // click continue

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //use to verify the home oage visible or not
    }
    @Test(priority = 5)
    public void exisitngRegisterTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h2[contains(text(),'New User Signup')]"))));
        Assert.assertTrue(newuser.isDisplayed());

        file.signup("aaaa","san123@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Email Address already exist!')]"))).isDisplayed();
    }
    @Test(priority = 6)
    public void contactusTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        WebElement contact =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Contact')]")));
        contact.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Get In Touch')]"))).isDisplayed();

        file.contact("AAA","aabbcc11@gmail.com","hiiii","hello");

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));
    }
    @Test(priority = 7)
    public void testcasesTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        WebElement testcases=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(normalize-space(),'Test Cases')]")));
        testcases.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),' Test Cases')]"))).isDisplayed();
    }
    @Test(priority = 8)
    public void verifyProductTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //Verify home page visible

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/products")); //check the current page in products

        Assert.assertTrue(driver.getCurrentUrl().contains("products")); //verify all products list

        List<WebElement> products=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']"));
        Assert.assertTrue(products.size() > 0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //a[contains(text(),'View Product')]"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/product_details/1"));

        WebElement name=driver.findElement(By.xpath("//div[@class='product-information']//h2"));
        Assert.assertTrue(name.isDisplayed()); // Name

        WebElement category=driver.findElement(By.xpath("//div[@class='product-information']//p"));
        Assert.assertTrue(category.isDisplayed()); // Category
    }
    @Test(priority = 9)
    public void searchProductTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //Verify home page visible

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/products")); //check the current page in products

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product"))).sendKeys("Tshirt");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_search"))).click();

        WebElement searchProducts= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(searchProducts.isDisplayed());

        List<WebElement> searchproducts=driver.findElements(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(searchproducts.size() > 0);
    }
    @Test(priority = 10)
    public void verifySubscriptionTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //verify Home Page

        WebElement footer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

        Actions action=new Actions(driver);
        action.moveToElement(footer).perform();

        WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='single-widget']//h2")));
        Assert.assertTrue(sub.isDisplayed()); //verify the subscription text

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("susbscribe_email"))).sendKeys("aaa@gmail.com"); // enter email id

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe"))).click();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]")));

        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not visible");
    }
    @Test(priority = 11)
    public void cartSubscriptionTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //verify Home Page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click();

        WebElement footer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

        Actions action=new Actions(driver);
        action.moveToElement(footer).perform();

        WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='single-widget']//h2")));
        Assert.assertTrue(sub.isDisplayed()); //verify the subscription text

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("susbscribe_email"))).sendKeys("aaa@gmail.com"); // enter email id

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe"))).click();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]")));

        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not visible");
    }
    @Test(priority = 12)
    public void addproductcartTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //verify Home Page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click(); // click Product

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1']"))).click(); // click first product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click(); // click continue shopping

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='2']"))).click(); // click 2nd product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click(); // click view cart on 2nd product

        List<WebElement> cart=driver.findElements(By.id("cart_info"));
        Assert.assertTrue(cart.size() > 0);
    }
    @Test(priority = 13)
    public void verifyproductTest()
    {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/product_details/1']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("product_details/1"));

        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity")));
        quantity.clear();
        quantity.sendKeys("4");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'cart')]"))).click();

        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']")));
        viewCart.click();

        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_quantity']//button")));

        String quantityText = quantityElement.getText();

        Assert.assertEquals(quantityText.trim(), "4");
    }
    @Test(priority = 14)
    public void placeorderTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //verify Home Page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1']"))).click(); // click first product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click(); // click continue shopping

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='2']"))).click(); // click 2nd product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click(); // click view cart on 2nd product

        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/view_cart")); //verify view cart page is visible or not

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-6']//a[contains(@class,'check_out')]"))).click(); //click proceed to checkout

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/u[text()='Register / Login']"))).click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h2[contains(text(),'New User Signup')]"))));
        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

        //file.signup("twelve","twelvw2026@gmail.com");

        file.createaccount("dhoni@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click(); // click Continue

        WebElement loggedelement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(text(),'Logged in as')]")));
        Assert.assertTrue(loggedelement.isDisplayed());

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[@href='/delete_account']"))).click(); //click delete button

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-qa='continue-button']"))).click(); // click continue

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click();  //click cart button

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'check_out')]"))).click(); //click proceed to checkout

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("I am going to purchase this product");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/payment']"))).click();

        file.payment("Srinivas","123456789012","144","12","2026");

        WebElement paymentBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class,'check_out')]")));

        paymentBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Congratulations!')]")));

        WebElement logout = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/logout']")));

        logout.click();
    }
    @Test(priority = 15)
    public void orderBeforeCheckoutTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //verify home page

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h2[contains(text(),'New User Signup')]"))));
        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

        //file.signup("thirteen","thirteen2026@gmail.com");

        file.createaccount("dhoni@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click(); // click Continue

        WebElement loggedelement=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(.,'Logged in as')]"))));
        String logintxt=loggedelement.getText();
        Assert.assertTrue(logintxt.contains("Logged in as"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click(); //click product buttom

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1']"))).click(); // click first product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click(); // click continue shopping

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='2']"))).click(); // click 2nd product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click(); // click view cart on 2nd product

        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/view_cart")); //verify cart page visible or not

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default check_out']"))).click(); //click proceed to checkout

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("I am going to purchase this product");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/payment']"))).click();

        file.payment("Srinivas","123456789012","144","12","2026");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Congratulations!')]")));

        WebElement logout = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/logout']")));

        logout.click();
    }
    @Test(priority = 16)
    public void placeOrderLoginTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //verify home page

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();  //click login/signup page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login to your account']"))).isDisplayed();

        file.login("samson2026@gmail.com","abc@123");

        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click(); //click product

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1']"))).click(); // click first product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click(); // click continue shopping

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='2']"))).click(); // click 2nd product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click(); // click view cart on 2nd product

        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/view_cart")); //verify view cart page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default check_out']"))).click(); //click proceed to checkout

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("I am going to purchase this product");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/payment']"))).click();

        file.payment("Srinivas","123456789012","144","12","2026");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Congratulations!')]")));

        WebElement logout = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/logout']")));

        logout.click();
    }
    @Test(priority = 17)
    public void removeproductTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); //verify home page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click(); //click product

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click(); // click continue shopping

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='2']"))).click();// click first product add to the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click(); // click view cart on 1nd product

        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/view_cart")); //verify view cart page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cart_quantity_delete' and @data-product-id='1']"))).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@data-product-id='1']")));

        Assert.assertTrue(driver.findElements(By.xpath("//a[@data-product-id='1']")).isEmpty(), "Product 1 still present");

        Assert.assertTrue(driver.findElements(By.xpath("//a[@data-product-id='2']")).size() > 0, "Product 2 missing from cart");
    }
    @Test(priority = 18)
    public void viewCategoryTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left-sidebar']//h2[text()='Category']"))).isDisplayed(); //verify the "category" present or not

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#Women']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/category_products/1']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Women - Dress Products')]"))).isDisplayed();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#Men']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/category_products/3']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Men - Tshirts Products')]"))).isDisplayed();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Men - Tshirts Products')]"))).isDisplayed();
    }
    @Test(priority = 19)
    public void viewcartbrandTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left-sidebar']//h2[text()='Brands']"))).isDisplayed();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/brand_products/Polo']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(normalize-space(), 'Brand - Polo Products')]"))).isDisplayed();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/brand_products/H&M']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(normalize-space(), 'Brand - H&M Products')]"))).isDisplayed();
    }
    @Test(priority = 20)
    public void searchverifycartTest() throws InterruptedException
    {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        // ✅ STEP 1: CLEAR CART BEFORE TEST
        file.clearCartIfPresent();

        // Go to Products page
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'All Products')]")));

        // Search product
        driver.findElement(By.id("search_product")).sendKeys("Tshirt");
        driver.findElement(By.id("submit_search")).click();

        // Verify searched products text
        String txt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[@class='title text-center']"))).getText();

        Assert.assertEquals(txt1, "SEARCHED PRODUCTS");

        // Get product cards
        List<WebElement> productCards = driver.findElements(
                By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']")
        );

        Assert.assertTrue(productCards.size() > 0, "No products found!");

        List<String> productNames = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // ✅ STEP 2: ADD PRODUCTS
        for (int i = 0; i < productCards.size(); i++)
        {
            WebElement card = productCards.get(i);

            String name = card.findElement(By.xpath(".//p")).getText();
            productNames.add(name.toLowerCase());

            Assert.assertTrue(name.toLowerCase().contains("shirt"));

            WebElement addBtn = card.findElement(By.xpath(".//a[contains(@class,'add-to-cart')]"));

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", addBtn);
            js.executeScript("arguments[0].click();", addBtn);

            if (i < productCards.size() - 1)
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[text()='Continue Shopping']"))).click();
            }
        }

        // Go to Cart BEFORE login
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        List<WebElement> cartProducts = driver.findElements(
                By.xpath("//td[@class='cart_description']/h4/a")
        );

        System.out.println("Expected products: " + productNames.size());
        System.out.println("Actual cart items (before login): " + cartProducts.size());

        // ✅ Validate BEFORE login (strict)
        Assert.assertEquals(cartProducts.size(), productNames.size());

        // Login
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Login to your account']")));

        file.login("samson2026@gmail.com", "abc@123");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Logged in as')]")));

        // Go to cart AFTER login
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        List<WebElement> cartProductsAfter = driver.findElements(
                By.xpath("//td[@class='cart_description']/h4/a")
        );

        System.out.println("Actual cart items (after login): " + cartProductsAfter.size());

        // ✅ STEP 3: VALIDATE ONLY PRODUCTS ADDED IN THIS TEST
        int matchedCount = 0;

        for (WebElement cartItem : cartProductsAfter)
        {
            String cartName = cartItem.getText().toLowerCase();

            if (cartName.contains("shirt"))
            {
                matchedCount++;
            }
        }

        Assert.assertEquals(matchedCount, productNames.size());
    }
    @Test(priority = 21)
    public void addreviewproductTest()
    {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'All Products')]"))).isDisplayed();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/product_details/1']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Write Your Review']"))).isDisplayed();

        file.review("Srinivas","srinivas123@gmail.com","good product");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Thank you for your review')]"))).isDisplayed();
    }
    @Test(priority = 22)
    public void recommendedproductTest() throws InterruptedException
    {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));  // Verify home page

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 6; i++)    // Scroll slowly to trigger loading
        {
            js.executeScript("window.scrollBy(0,800)");
            Thread.sleep(500); // small pause helps lazy load
        }

        WebElement recommended = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'recommended items')]")));   // Now wait for correct element

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", recommended);  //// Scroll to element

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='recommended-item-carousel']//a[contains(text(),'Add to cart')])[1]"))).click();  // Click Add to Cart

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cartModal']//a[@href='/view_cart']"))).click(); //// Click View Cart

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));  // Verify cart page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='cart_info_table']//tbody//tr"))); // Verify product exists
    }
    @Test(priority = 23)
    public void verifyaddTest() throws InterruptedException
    {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h2[contains(text(),'New User Signup')]"))));
        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

        //file.signup("fourteen","fourteen2026@gmail.com");

        file.createaccount("dhoni@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click();

        WebElement loggedelement=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(.,'Logged in as')]"))));
        String logintxt=loggedelement.getText();
        Assert.assertTrue(logintxt.contains("Logged in as"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@data-product-id='1' and contains(@class,'add-to-cart')]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        Thread.sleep(1000);
        addToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default check_out']"))).click();


        WebElement deliveryAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='address_delivery']")));  // Delivery Address

        WebElement billingAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='address_invoice']"))); // Billing Address

        String deliveryText = deliveryAddress.getText().replaceAll("\\s+", " ").trim();
        String billingText = billingAddress.getText().replaceAll("\\s+", " ").trim();

        String cleanDelivery = deliveryText.replace("YOUR DELIVERY ADDRESS", "").trim();
        String cleanBilling = billingText.replace("YOUR BILLING ADDRESS", "").trim();

        Assert.assertEquals(cleanDelivery, cleanBilling, "Delivery and Billing address are NOT same");
    }
    @Test(priority = 24)
    public void downloadinvoiceTest() throws InterruptedException
    {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); // verify home page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click(); //click product button

        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1' and contains(@class,'add-to-cart')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

        WebElement viewCartPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[text()='View Cart']")));
        viewCartPopup.click();  //click view cart

        wait.until(ExpectedConditions.urlContains("view_cart"));
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));

        WebElement checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Proceed To Checkout')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();

        WebElement signupLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[text()='Register / Login']")));
        signupLogin.click(); //click login or register

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'New User Signup')]")));

        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

        //file.signup("fifteen", "fifteen2026@gmail.com");

        file.createaccount("dhoni@123", "srinivas", "JG", "HCL", "anna nagar", "madurai", "tamilnadu", "madurai", "613001", "1234567890");

        WebElement accountcreatedvisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));

        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click();

        WebElement loggedelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Logged in as')]")));

        Assert.assertTrue(loggedelement.getText().contains("Logged in as"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click();

        WebElement checkoutBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Proceed To Checkout')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn2);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn2)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("I am going to purchase this product");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/payment']"))).click();

        file.payment("Srinivas", "123456789012", "144", "12", "2026");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Congratulations!')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'/download_invoice')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-qa='continue-button']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]"))).click();
    }
    @Test(priority = 25)
    public void scrollupTest() throws InterruptedException {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com")); // verify home page

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='single-widget']//h2[text()='Subscription']"))).isDisplayed();

        WebElement scrollUpArrow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@id='scrollUp']")
        ));
        scrollUpArrow.click();

        Thread.sleep(2000); // wait for scroll up

        // 6. Verify page is scrolled up (top text visible)
        WebElement topText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
        ));

        Assert.assertTrue(topText.isDisplayed(), "Top text not visible after scrolling up");
    }
    @Test(priority = 26)
    public void scrolldownTest() throws InterruptedException {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 4. Scroll down to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(2000); // allow page load

        // 5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Subscription')]")
        ));
        Assert.assertTrue(subscription.isDisplayed());

        // 6. Scroll up to top (WITHOUT arrow button)
        js.executeScript("window.scrollTo(0, 0);");

        Thread.sleep(2000);

        // 7. Verify top text is visible
        WebElement topText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
        ));

        Assert.assertTrue(topText.isDisplayed());
    }
}
