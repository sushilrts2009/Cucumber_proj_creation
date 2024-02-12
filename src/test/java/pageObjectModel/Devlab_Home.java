package pageObjectModel;

import org.openqa.selenium.By;

public class Devlab_Home {

    public By loginbutton()
    {
        return By.xpath("//button[@id='header_Button']");
    }

    public By userloginbutton()
    {
        return By.xpath("//button[contains(@class, 'MuiButtonBase-root M')]//span[text()='Login']");
    }

    public By userid_textbox()
    {
        return By.xpath("//input[@name='email']");
    }

    public By user_password()
    {
        return By.xpath("//input[@name='password']");
    }

    public By devlaplogo()
    {
        return By.xpath("(//img[@alt='DevLabs Alliance Logo'])[1]");
    }

}
