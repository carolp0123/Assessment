package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // accept the driver
    private WebDriver driver; /* create driver variable */

    // set up the fields
    public By firstUserName = By.xpath("/html/body/table/tbody/tr[1]/td[1]");
    public By secondUserName = By.xpath("/html/body/table/tbody/tr[2]/td[1]");
    public By addUser = By.xpath("/html/body/table/thead/tr[2]/td/button");

    // create the constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // clicking on the Add User link
    public ModalPopupPage clickaddUser(){

        driver.findElement(addUser).click();

        return new ModalPopupPage(driver); /* passing the session to the modal popup */
    }

}
