package baseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserListTableTest extends BaseTests {

    @Test
    public void AssertUserList(){
        // validate that we are on the User List Table
        String logPage = "https://www.way2automation.com/angularjs-protractor/webtables/";
        String curPage = driver.getCurrentUrl();
        Assert.assertEquals(logPage,curPage);
    }
}
