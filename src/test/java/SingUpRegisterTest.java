import org.openqa.selenium.By;
  import org.openqa.selenium.WebElement;
    import org.testng.Assert;
      import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SingUpRegisterTest extends BaseTest{
    String registerButtonlocator = "[value=Register]";
    String firstnameInputLocator = "first_name";
    String lastnameInputLocator = "last_name";
    String emailInputLocator = "email";
    String passwordLocator = "password1";
    String confirmPasswordLocator = "password2";
    String errorMessageLocator = "[class='error_message']";

    @Test
    public void registerUserWithValidDate(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector("[class='confirmation_message']")).isDisplayed();
        Assert.assertTrue(confirmMessage,"Пользователь не перешёл на confirmation_message");

    }

    @Test
    public void doNotEnterAnythingInTheRegistrationFields(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys((""));
        driver.findElement(By.name(emailInputLocator)).sendKeys("");
        driver.findElement(By.name(passwordLocator)).sendKeys("");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void leaveFirstNameFieldEmpty(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void leaveLastNameFieldEmpty(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys((""));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
}

    @Test
    public void leaveEmailFieldEmpty(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void leavePasswordFieldEmpty(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
}

    @Test
    public void leaveConfirmPasswordFieldEmpty(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInFirstNameField5Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("12345");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInLastNameField5Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("12345"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInFirstNameFieldOneCharacter(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("E");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInLastNameFieldOneCharacter(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("M"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    public void  inputInEmailField5Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("12345");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    public void  inputInEmailFieldUnCorrectEmail(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("##$%&^*@mail.ru");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInPasswordField3Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("123");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInConfirmPasswordField3Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("123");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInPasswordField5Characters(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("*****");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInConfirmPasswordField5Characters(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("*****");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInFirstNameField5Characters(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("*****");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInLastNameField5Characters(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("*****"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInFirstNameFieldSpaceAnd5Character(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys(" Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInLastNameFieldSpaceAnd5Character(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys((" Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInEmailFieldSpaceAndValidEmail(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys(" evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInPasswordFieldSpaceAnd5Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys(" 12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInPasswordConfirmFieldSpaceAnd5Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys(" 12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInFirstNameField5CharactersAndSpacer(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy ");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInLastNameField5CharactersAndSpacer(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas "));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInEmailField5CharactersAndSpacer(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com ");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInPasswordField5CharactersAndSpacer(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345 ");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void  inputInPasswordConfirmField5CharactersAndSpacer(){
        driver.get(BASE_URL+"cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name(firstnameInputLocator)).sendKeys("Evgeniy");
        driver.findElement(By.name(lastnameInputLocator)).sendKeys(("Matyas"));
        driver.findElement(By.name(emailInputLocator)).sendKeys("evgeniy@mail.com");
        driver.findElement(By.name(passwordLocator)).sendKeys("12345");
        driver.findElement(By.name(confirmPasswordLocator)).sendKeys("12345 ");
        driver.findElement(By.cssSelector(registerButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }
}