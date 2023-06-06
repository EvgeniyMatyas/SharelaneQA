import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SingUpRegisterTest extends BaseTest{
    String registerButtonlocator = "[value=Register]";
    @Test
    public void registerUserWithValidDate(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Evgeniy");
        driver.findElement(By.name("last_name")).sendKeys(("Matyas"));
        driver.findElement(By.name("email")).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector("[class='confirmation_message']")).isDisplayed();
        Assert.assertTrue(confirmMessage,"Пользователь не перешёл на confirmation_message");

    }
    @Test
    public void doNotEnterAnythingInTheRegistrationFields(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys((""));
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        WebElement error_message = driver.findElement(By.cssSelector("[class='error_message']"));
        String text = error_message.getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }
}