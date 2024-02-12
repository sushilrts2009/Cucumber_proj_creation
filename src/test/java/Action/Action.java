package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class Action {

    public WebDriver driver = null;

    boolean flag = false;

    public WebDriver getDriver()
    {
        driver = new ChromeDriver();
        return driver;
    }

    // this method to use read properties file
    public String read_poperties_file(String key)
    {
        String flag = null;
        try
        {
            Properties prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/Global.properties"));
            flag = prop.getProperty(key);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    // check for element present
    public boolean check_for_element_present(By by)
    {
        try
        {
            driver.findElement(by).isDisplayed();
            flag =true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }


    // This method is used to type in a text box

    public  boolean typeInTextBox(By by, String stringinput)
    {
        try
        {
            driver.findElement(by).sendKeys(stringinput);
            flag =true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean clickButtonsandExplicitWait(By by, int time)
    {
         try
         {
            driver.findElement(by).click();
            Thread.sleep(time);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }


}
