package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListPage {
    public EmployeeListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    String emailAdress = faker.internet().emailAddress();
    List<String> emailListS;
    int emailIndex;

    @FindBy(linkText = "Employee List")
    public WebElement employeList;

    @FindBy(xpath = "//a[text()='Create New']")
    public WebElement createNewButton;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='Salary']")
    public WebElement salary;

    @FindBy(xpath = "//input[@id='DurationWorked']")
    public WebElement durationWorked;

    @FindBy(xpath = "//input[@id='Grade']")
    public WebElement grade;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@value='Create']")
    public WebElement createButton;

    @FindBy(xpath = "//input[@value='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//td[5]")
    public List<WebElement> emailList;


    public void createNewEmployee() {
        ReusableMethods.wait(1);
        name.sendKeys(faker.name().fullName());
        salary.sendKeys("140000");
        durationWorked.sendKeys("5");
        grade.sendKeys("2");
        email.sendKeys(emailAdress);
        ReusableMethods.wait(1);
        createButton.click();

/*
//Action class ile yazdirmek icin kullanilabilir
ReusableMethods.wait(1);
name.click();
    actions.sendKeys(faker.name().fullName(), Keys.ENTER)
            .sendKeys(Keys.TAB)
            .sendKeys("140000",Keys.ENTER)
            .sendKeys(Keys.TAB)
            .sendKeys("5",Keys.ENTER)
            .sendKeys(Keys.TAB)
            .sendKeys("2",Keys.ENTER)
            .sendKeys(Keys.TAB)
            .sendKeys(faker.internet().emailAddress()).perform();
*/
    }

    public void verifyEmployeeList() {
        emailListS = new ArrayList<>();
        for (WebElement baslik : emailList) {
            emailListS.add(baslik.getText());
        }
        emailIndex = emailListS.indexOf(emailAdress);
        String actualMail = emailListS.get(emailIndex);
        Assert.assertEquals(emailListS.get(emailIndex), actualMail);

    }

    public void verifyDeleteEmployeeInformation() {
        ReusableMethods.clickWithJSAsList(emailList);
        //int mailIndex2=emailIndex+2;
        emailIndex = emailIndex + 2;
        WebElement delete = Driver.getDriver().findElement(By.xpath("//tr[" + emailIndex + "]/td[6]/a[3]"));
        ReusableMethods.wait(1);
        ReusableMethods.wait(1);
        delete.click();
        ReusableMethods.wait(1);
        deleteButton.click();
        emailListS = new ArrayList<>();

        for (WebElement baslik : emailList) {
            emailListS.add(baslik.getText());
        }
        Assert.assertFalse(emailListS.contains(emailAdress));


    }
}