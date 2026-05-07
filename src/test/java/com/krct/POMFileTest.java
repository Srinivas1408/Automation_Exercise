package com.krct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class POMFileTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    public POMFileTest(WebDriver driver,WebDriverWait wait)
    {
        this.driver=driver;
        this.wait=wait;
    }

    public void openlink()
    {
        driver.get("https://automationexercise.com/");
    }

    private final By name= By.xpath("//input[@data-qa='signup-name']");
    private final By email=By.xpath("//input[@data-qa='signup-email']");
    private final By signupbtn=By.xpath("//button[@data-qa='signup-button']");

    //low level

    //Enter name for signup
    public void entersignupname(String signupname)
    {
        driver.findElement(name).sendKeys(signupname);
    }

    //Enter email for signup
    public void entersignupemail(String signupemail)
    {
        driver.findElement(email).sendKeys(signupemail);
    }

    //click signup buttom
    public void clicksignupbtn()
    {
        driver.findElement(signupbtn).click();
    }

    //high level

    public void signup(String spname,String spemail)  //signupname ,signupemail for signup
    {
        entersignupname(spname);
        entersignupemail(spemail);
        clicksignupbtn();
    }

    // enter account information
    private final By password=By.id("password");
    private final By firstname=By.id("first_name");
    private final By lastname=By.id("last_name");
    private final By Company=By.id("company");
    private final By address1=By.id("address1");
    private final By address2=By.id("address2");
    private final By state=By.id("state");
    private final By City=By.id("city");
    private final By Zipcode=By.id("zipcode");
    private final By Mobilenumber=By.id("mobile_number");
    private final By Createaccbtn=By.xpath("//button[@type='submit']");

    //low level

    //enter password
    public void setPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    //enter first name
    public void setFirstname(String fname)
    {
        driver.findElement(firstname).sendKeys(fname);
    }

    //enter last name
    public void setLastname(String lname)
    {
        driver.findElement(lastname).sendKeys(lname);
    }

    //enter company
    public void setCompany(String company)
    {
        driver.findElement(Company).sendKeys(company);
    }

    //enter address1
    public void setAddress1(String add1)
    {
        driver.findElement(address1).sendKeys(add1);
    }

    //enter address2
    public void setAddress2(String add2)
    {
        driver.findElement(address2).sendKeys(add2);
    }

    //enter state
    public void setState(String states)
    {
        driver.findElement(state).sendKeys(states);
    }

    //enter city
    public void setCity(String city)
    {
        driver.findElement(City).sendKeys(city);
    }

    //enter zipcode
    public void setZipcode(String zipcode)
    {
        driver.findElement(Zipcode).sendKeys(zipcode);
    }

    //enter mobilenumber
    public void setMobilenumber(String mobilenumber)
    {
        driver.findElement(Mobilenumber).sendKeys(mobilenumber);
    }

    //click create account buttom
    public void clickcreateaccbtn()
    {
        driver.findElement(Createaccbtn).click();
    }

    //high code

    public void createaccount(String pass,String fname,String lname,String company,String add1,String add2,String state,String city,String zipcode,String mnumber)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-id_gender1"))).click();
        setPassword(pass);
        setFirstname(fname);
        setLastname(lname);

        //date of birth
        Select day=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("days"))));
        day.selectByVisibleText("14");
        Select month=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("months"))));
        month.selectByVisibleText("August");
        Select year=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years"))));
        year.selectByVisibleText("2004");

        //click checkboxes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newsletter"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("optin"))).click();

        //country
        Select country=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))));
        country.selectByVisibleText("India");

        setCompany(company);
        setAddress1(add1);
        setAddress2(add2);
        setState(state);
        setCity(city);
        setZipcode(zipcode);
        setMobilenumber(mnumber);
        clickcreateaccbtn();
    }


    //login page

    protected final By loginemail=By.xpath("//input[@data-qa='login-email']");
    protected final By loginpass=By.xpath("//input[@data-qa='login-password']");
    protected final By loginbtn=By.xpath("//button[@data-qa='login-button']");

    //low level

    //Enter Login email
    public void setLoginemail(String email)
    {
        driver.findElement(loginemail).sendKeys(email);
    }
    //Enter Login password
    public void setLoginPassword(String pass)
    {
        driver.findElement(loginpass).sendKeys(pass);
    }
    //Click login buttom
    public void clickloginbtn()
    {
        driver.findElement(loginbtn).click();
    }

    //high level
    public void login(String email,String pass)
    {
        setLoginemail(email);
        setLoginPassword(pass);
        clickloginbtn();
    }

    // Contact Us page

    protected final By Cname=By.xpath("//input[@data-qa='name']");
    protected final By Cemail=By.xpath("//input[@data-qa='email']");
    protected final By Csub=By.xpath("//input[@data-qa='subject']");
    protected final By Cmsg=By.id("message");
    protected final By choosefilebtn=By.name("upload_file");
    protected final By Csubmitbtn=By.xpath("//input[@data-qa='submit-button']");
    protected final By Chomebtn=By.xpath("//a[contains(@class,'btn-success')]");

    //low level
    public void setCName(String cname)
    {
        driver.findElement(Cname).sendKeys(cname);
    }
    public void setCemail(String cemail)
    {
        driver.findElement(Cemail).sendKeys(cemail);
    }
    public void setCsub(String csub)
    {
        driver.findElement(Csub).sendKeys(csub);
    }
    public void setCmsgs(String cmsg)
    {
        driver.findElement(Cmsg).sendKeys(cmsg);
    }
    public void setChoosefilebtn()
    {
        driver.findElement(choosefilebtn).sendKeys("D:\\INTERN PPT.ppt");
    }
    public void setCsubmitbtn()
    {
        driver.findElement(Csubmitbtn).click();
    }
    public void setChomebtn()
    {
        driver.findElement(Chomebtn).click();
    }

    //high level
    public void contact(String cname,String cemail,String csubject,String cmsg)
    {
        setCName(cname);
        setCemail(cemail);
        setCsub(csubject);
        setCmsgs(cmsg);
        setChoosefilebtn();
        setCsubmitbtn();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement res = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully')]"))));
        Assert.assertTrue(res.isDisplayed());

        setChomebtn();
    }

    //payment page

    protected final By nameoncard=By.name("name_on_card");
    protected final By cardnumber=By.name("card_number");
    protected final By cvc=By.name("cvc");
    protected final By expirymonth=By.name("expiry_month");
    protected final By expiryYear=By.name("expiry_year");
    protected final By paybtn=By.cssSelector("#submit");

    //low level
    public void setNameoncard(String name)
    {
        driver.findElement(nameoncard).sendKeys(name);
    }
    public void setCardnumber(String cardno)
    {
        driver.findElement(cardnumber).sendKeys(cardno);
    }
    public void setCvc(String cvcno)
    {
        driver.findElement(cvc).sendKeys(cvcno);
    }
    public void setExpirymonth(String expirydate)
    {
        driver.findElement(expirymonth).sendKeys(expirydate);
    }
    public void setExpiryyear(String expiryyear)
    {
        driver.findElement(expiryYear).sendKeys(expiryyear);
    }
    public void setPaybtn()
    {
        driver.findElement(paybtn).click();
    }

    //high level
    public void payment(String name,String cardno,String cvc,String exp,String expyear)
    {
        setNameoncard(name);
        setCardnumber(cardno);
        setCvc(cvc);
        setExpirymonth(exp);
        setExpiryyear(expyear);
        setPaybtn();
    }

    //testcase 21 write an review

    protected final By wyrname=By.id("name");
    protected final By wyremail=By.id("email");
    protected final By wyrreviw=By.id("review");
    protected final By submitbtn=By.id("button-review");

    //low level
    public void setWyrname(String name)
    {
        driver.findElement(wyrname).sendKeys(name);
    }
    public void setWyremail(String email)
    {
        driver.findElement(wyremail).sendKeys(email);
    }
    public void setWyrreviw(String review)
    {
        driver.findElement(wyrreviw).sendKeys(review);
    }
    public void setSubmitbtn()
    {
        driver.findElement(submitbtn).click();
    }

    //high level
    public void review(String name,String email,String Review)
    {
        setWyrname(name);
        setWyremail(email);
        setWyrreviw(Review);
        setSubmitbtn();
    }

    public void clearCartIfPresent()
    {
        driver.get("https://automationexercise.com/view_cart");

        List<WebElement> deleteButtons = driver.findElements(
                By.xpath("//a[@class='cart_quantity_delete']")
        );

        for (WebElement btn : deleteButtons)
        {
            try {
                btn.click();
                Thread.sleep(1000); // allow UI update
            } catch (Exception e) {
                System.out.println("Cart already empty");
            }
        }
    }







}


