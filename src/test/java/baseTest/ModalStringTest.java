package baseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ModalPopupPage;

public class ModalStringTest extends BaseTests{

    @Test
    public void modalTest(){

        ModalPopupPage modalPopupPage = homePage.clickaddUser();

        //set up data
        String[] user1 ={"FName1", "LName1", "User1", "Pass1", "Admin", "admin@mail.com", "082555",};
        String[] user2 ={"FName2", "LName2", "User2", "Pass2", "Customer", "customer@mail.com", "083444",};

        // capture first user
        modalPopupPage.setFirstName(user1[0]);
        modalPopupPage.setLastName(user1[1]);
        modalPopupPage.setUserName(user1[2]);
        modalPopupPage.setPassWord(user1[3]);
        modalPopupPage.setRole(user1[4]);
        modalPopupPage.setEmail(user1[5]);
        modalPopupPage.setCellPhone(user1[6]);
        modalPopupPage.clickSave();

        homePage.clickaddUser();

        // capture second user
        modalPopupPage.setFirstName(user2[0]);
        modalPopupPage.setLastName(user2[1]);
        modalPopupPage.setUserName(user2[2]);
        modalPopupPage.setPassWord(user2[3]);
        modalPopupPage.setRole(user2[4]);
        modalPopupPage.setEmail(user2[5]);
        modalPopupPage.setCellPhone(user2[6]);
        modalPopupPage.clickSave();

        // Ensure users are added to the list, second user appearing first in the list

        String firstNameChk = driver.findElement(homePage.firstUserName).getText();
        Assert.assertEquals(firstNameChk,user2[0]);
        String secondNameChk = driver.findElement(homePage.secondUserName).getText();
        Assert.assertEquals(secondNameChk,user1[0]);

    }
}
