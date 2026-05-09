package com.krct;

import com.krct.POMFileTest;
import com.krct.baseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class searchEngineTest extends baseTest
{
    // Shared email variable for tests that create accounts
    private String dynamicEmail = null;

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

        dynamicEmail = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", dynamicEmail);

        WebElement accountvisible=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[contains(text(),'Enter Account Information')]"))));
        Assert.assertTrue(accountvisible.isDisplayed());

        file.createaccount("abc@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click();

        WebElement loggedelement=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(.,'Logged in as')]"))));
        String logintxt=loggedelement.getText();
        Assert.assertTrue(logintxt.contains("Logged in as"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]"))).click();
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
        Assert.assertTrue(flash.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]"))).click();
    }

    @Test(priority = 3)
    public void loginFailureTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login to your account']"))).isDisplayed();

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
        Assert.assertTrue(flash.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));
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

        file.signup("aaaa","samson2026@gmail.com");

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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("products"));

        List<WebElement> products=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']"));
        Assert.assertTrue(products.size() > 0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'View Product')]"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"));

        WebElement name=driver.findElement(By.xpath("//div[@class='product-information']//h2"));
        Assert.assertTrue(name.isDisplayed());

        WebElement category=driver.findElement(By.xpath("//div[@class='product-information']//p"));
        Assert.assertTrue(category.isDisplayed());
    }

    @Test(priority = 9)
    public void searchProductTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product"))).sendKeys("Tshirt");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_search"))).click();

        WebElement searchProducts= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(searchProducts.isDisplayed());

        List<WebElement> searchproducts=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']"));
        Assert.assertTrue(searchproducts.size() > 0);
    }

    @Test(priority = 10)
    public void verifySubscriptionTest()
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        WebElement footer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

        Actions action=new Actions(driver);
        action.moveToElement(footer).perform();

        WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='single-widget']//h2")));
        Assert.assertTrue(sub.isDisplayed());

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("susbscribe_email")));
        emailInput.clear();
        emailInput.sendKeys("aaa@gmail.com");

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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click();

        WebElement footer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

        Actions action=new Actions(driver);
        action.moveToElement(footer).perform();

        WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='single-widget']//h2")));
        Assert.assertTrue(sub.isDisplayed());

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("susbscribe_email")));
        emailInput.clear();
        emailInput.sendKeys("aaa@gmail.com");

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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='1']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']"))).click();

        List<WebElement> cart=driver.findElements(By.xpath("//table[@id='cart_info_table']//tr"));
        Assert.assertTrue(cart.size() > 1);
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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='1']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='Register / Login']"))).click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h2[contains(text(),'New User Signup')]"))));
        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

        file.createaccount("dhoni@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        WebElement loggedelement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(text(),'Logged in as')]")));
        Assert.assertTrue(loggedelement.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();

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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h2[contains(text(),'New User Signup')]"))));
        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

        file.createaccount("dhoni@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click();

        WebElement loggedelement=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(.,'Logged in as')]"))));
        String logintxt=loggedelement.getText();
        Assert.assertTrue(logintxt.contains("Logged in as"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='1']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default check_out']"))).click();

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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        WebElement signuplogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        signuplogin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login to your account']"))).isDisplayed();

        file.login("samson2026@gmail.com","abc@123");

        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));
        Assert.assertTrue(flash.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='1']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default check_out']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("I am going to purchase this product");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/payment']"))).click();

        file.payment("Srinivas","123456789012","144","12","2026");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Congratulations!')]")));

        WebElement logout = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/logout']")));

        logout.click();
    }

    @Test(priority = 17)
    public void removeproductTest() throws InterruptedException
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='1']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']"))).click();

        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart_quantity_delete' and @data-product-id='1']")));
        deleteBtn.click();

        Thread.sleep(1000);

        boolean product1Exists = driver.findElements(By.xpath("//a[@data-product-id='1']")).size() > 0;
        Assert.assertFalse(product1Exists, "Product 1 should be removed");

        boolean product2Exists = driver.findElements(By.xpath("//a[@data-product-id='2']")).size() > 0;
        Assert.assertTrue(product2Exists, "Product 2 should still be present");
    }

    @Test(priority = 18)
    public void viewCategoryTest() throws InterruptedException
    {
        POMFileTest file=new POMFileTest(driver,wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left-sidebar']//h2[text()='Category']"))).isDisplayed();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#Women']"))).click();

        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/category_products/1']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Women - Dress Products')]"))).isDisplayed();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#Men']"))).click();

        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/category_products/3']"))).click();

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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/brand_products/Polo']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(normalize-space(), 'Brand - Polo Products')]"))).isDisplayed();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/brand_products/H&M']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(normalize-space(), 'Brand - H&M Products')]"))).isDisplayed();
    }

    @Test(priority = 20)
    public void searchverifycartTest() throws InterruptedException
    {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        file.clearCartIfPresent();

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'All Products')]")));

        driver.findElement(By.id("search_product")).sendKeys("Tshirt");
        driver.findElement(By.id("submit_search")).click();

        String txt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[@class='title text-center']"))).getText();

        Assert.assertEquals(txt1, "SEARCHED PRODUCTS");

        List<WebElement> productCards = driver.findElements(
                By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']")
        );

        Assert.assertTrue(productCards.size() > 0, "No products found!");

        List<String> productNames = new ArrayList<>();

        for (int i = 0; i < productCards.size(); i++)
        {
            WebElement card = productCards.get(i);

            String name = card.findElement(By.xpath(".//p")).getText();
            productNames.add(name.toLowerCase());

            Assert.assertTrue(name.toLowerCase().contains("shirt"));

            WebElement addBtn = card.findElement(By.xpath(".//a[contains(@class,'add-to-cart')]"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);

            if (i < productCards.size() - 1)
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[text()='Continue Shopping']"))).click();
            }
        }

        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        List<WebElement> cartProducts = driver.findElements(
                By.xpath("//td[@class='cart_description']/h4/a")
        );

        Assert.assertEquals(cartProducts.size(), productNames.size());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Login to your account']")));

        file.login("samson2026@gmail.com", "abc@123");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Logged in as')]")));

        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        List<WebElement> cartProductsAfter = driver.findElements(
                By.xpath("//td[@class='cart_description']/h4/a")
        );

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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/product_details/1']"))).click();

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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 6; i++)
        {
            js.executeScript("window.scrollBy(0,800)");
            Thread.sleep(500);
        }

        WebElement recommended = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'recommended items')]")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", recommended);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='recommended-item-carousel']//a[contains(text(),'Add to cart')])[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cartModal']//a[@href='/view_cart']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='cart_info_table']//tbody//tr")));
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

        file.createaccount("dhoni@123","srinivas","JG","HCL","anna nagar","madurai","tamilnadu","madurai","613001","1234567890");

        WebElement accountcreatedvisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));
        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click();

        WebElement loggedelement=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(.,'Logged in as')]"))));
        String logintxt=loggedelement.getText();
        Assert.assertTrue(logintxt.contains("Logged in as"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@data-product-id='1' and contains(@class,'add-to-cart')]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        Thread.sleep(1000);
        addToCart.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default check_out']"))).click();

        WebElement deliveryAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='address_delivery']")));

        WebElement billingAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='address_invoice']")));

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

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='1' and contains(@class,'add-to-cart')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        Thread.sleep(1000);
        addToCart.click();

        WebElement viewCartPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']")));
        viewCartPopup.click();

        wait.until(ExpectedConditions.urlContains("view_cart"));
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));

        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed To Checkout')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
        Thread.sleep(1000);
        checkoutBtn.click();

        WebElement signupLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='Register / Login']")));
        signupLogin.click();

        WebElement newuser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'New User Signup')]")));

        Assert.assertTrue(newuser.isDisplayed());

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        file.signup("eleven", email);

        file.createaccount("dhoni@123", "srinivas", "JG", "HCL", "anna nagar", "madurai", "tamilnadu", "madurai", "613001", "1234567890");

        WebElement accountcreatedvisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Account Created')]")));

        Assert.assertTrue(accountcreatedvisible.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']"))).click();

        WebElement loggedelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Logged in as')]")));

        Assert.assertTrue(loggedelement.getText().contains("Logged in as"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']"))).click();

        WebElement checkoutBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed To Checkout')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn2);
        Thread.sleep(1000);
        checkoutBtn2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("I am going to purchase this product");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/payment']"))).click();

        file.payment("Srinivas", "123456789012", "144", "12", "2026");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Congratulations!')]")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/download_invoice')]"))).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-qa='continue-button']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]"))).click();
    }

    @Test(priority = 25)
    public void scrollupTest() throws InterruptedException {
        POMFileTest file = new POMFileTest(driver, wait);
        file.openlink();
        get();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='single-widget']//h2[text()='Subscription']"))).isDisplayed();

        WebElement scrollUpArrow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@id='scrollUp']")
        ));
        scrollUpArrow.click();

        Thread.sleep(2000);

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

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(2000);

        WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Subscription')]")
        ));
        Assert.assertTrue(subscription.isDisplayed());

        js.executeScript("window.scrollTo(0, 0);");

        Thread.sleep(2000);

        WebElement topText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
        ));

        Assert.assertTrue(topText.isDisplayed());
    }
}