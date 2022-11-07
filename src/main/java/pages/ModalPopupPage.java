package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ModalPopupPage {

    // accept the driver
    private WebDriver driver;

    // set up fields
    private By firstName = By.name("FirstName");
    private By lastName = By.name("LastName");
    private By userName = By.name("UserName");
    private By passWord = By.name("Password");
    private By customerA = By.xpath("//html/body/div[4]/div[2]/form/table/tbody/tr[5]/td[2]/label[1]/input\n");
    private By customerB = By.xpath("//html/body/div[4]/div[2]/form/table/tbody/tr[5]/td[2]/label[2]/input\n");
    private By role = By.name("RoleId");
    private By email = By.name("Email");
    private By cellPhone = By.name("Mobilephone");
    //private By save = By.xpath("//div[@class='modal-footer']/button[@ng-click='save(user)']");
    private By save = By.xpath("//button[@ng-click='save(user)']");

    // create constructor
    public ModalPopupPage(WebDriver driver){
        this.driver = driver;
    }

    // input methods
    public void setFirstName(String firstNamein){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(firstNamein);
    }
    public void setLastName(String lastNamein){
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lastNamein);
    }
    public void setUserName(String userNamein){
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(userNamein);
    }
    public void setPassWord(String passWordin){
        driver.findElement(passWord).clear();
       driver.findElement(passWord).sendKeys(passWordin);
    }

    public void selectCustomer(){
        WebElement cusA = driver.findElement(customerA);
        WebElement cusB = driver.findElement(customerB);

        boolean iscusSelect = cusA.isSelected();
        if(iscusSelect){
            cusB.click();
        } else {
            cusA.click();
        }
    }

    public void setRole(String rolein){
        Select roleList = new Select(driver.findElement(role));
        roleList.selectByVisibleText(rolein);
    }

    public void setEmail(String emailin){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailin);
    }
    public void setCellPhone(String cellPhonein){
        driver.findElement(cellPhone).clear();
        driver.findElement(cellPhone).sendKeys(cellPhonein);
    }

    public HomePage clickSave(){
        driver.findElement(save).click();
        return new HomePage(driver);
    }

}
