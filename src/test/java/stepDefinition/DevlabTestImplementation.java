package stepDefinition;

import PasswordEncryption.EncrptDcrpt;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.*;

import Action.Action;

import java.time.Duration;


public class DevlabTestImplementation extends Action
{
    private WebDriver driver = null;
    pageObjectModel.Devlab_Home obj_devlab_home = new pageObjectModel.Devlab_Home();
    PasswordEncryption.EncrptDcrpt obj_encdc = new PasswordEncryption.EncrptDcrpt();

    //cucumber hooks
    // common steps e.g. launch & close we can skip
    @Before
    public void setup()
    {
        driver=getDriver();

        String url = read_poperties_file("url");
       // driver.get("https://www.devlabsalliance.com/");
        driver.get(url);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    // copy of step definitions
    @Given("user launch Devlab application")
    public void user_launch_devlab_application()
    {
        // Write code here that turns the phrase above into concrete actions
        // without Action class
        //driver = new ChromeDriver();

        // with Action class
/*        driver=getDriver();
        driver.get("https://www.devlabsalliance.com/");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();*/

    }

    @Then("user validate the home page title")
    public void user_validate_the_home_page_title()
    {
        // Write code here that turns the phrase above into concrete actions

        String strttile = driver.getTitle();
        System.out.println("Title of the page is : " + strttile);
        Assert.assertEquals(driver.getTitle(),"Devlabs Alliance offers consulting and workshops on AI, RPA, DevOps, Big Data, Block Chain, Automation.");
    }

    @Then("user validate devlab logo")
    public void user_validate_devlab_logo()
    {
        // Validation Using assertion
        Assert.assertTrue(check_for_element_present(obj_devlab_home.loginbutton()));
        System.out.println("DevLabs logos are present");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    @When("user click on login button")
    public void user_click_on_login_button() throws Exception
    {
        // Write code here that turns the phrase above into concrete actions
        if (driver.findElement(obj_devlab_home.loginbutton()).isDisplayed()) {
            driver.findElement(obj_devlab_home.loginbutton()).click();
            Thread.sleep(3000);
            System.out.println("Login button - clicked");
        }

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    @Then("login popup screen displays")
    public void login_popup_screen_displays() throws Exception
    {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("user gives input as user name and passowrd")
    public void user_gives_input_as_user_name_and_passowrd() throws Exception
    {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("Default value 'Enter Email' is present");

        // Enter User ID
        typeInTextBox(obj_devlab_home.userid_textbox(),obj_encdc.returnDevlabUserID());

        //Check if by default "Enter Password" is present
        System.out.println("Default value 'Enter Password' is present");

        // Enter password
        typeInTextBox(obj_devlab_home.user_password(),obj_encdc.returnDevlabPassword());

        Thread.sleep(2000);

        clickButtonsandExplicitWait(obj_devlab_home.userloginbutton(),30);

    }

    @Then("user close the login pop up")
    public void user_close_the_login_pop_up()
    {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().refresh();
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Then("user close the application")
    public void user_close_the_application()
    {
        // Write code here that turns the phrase above into concrete actions
     //   driver.quit();
    }

}
