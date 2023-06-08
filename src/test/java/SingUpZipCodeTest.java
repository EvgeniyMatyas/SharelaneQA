import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
    import org.testng.Assert;
      import org.testng.annotations.Test;
        import org.w3c.dom.Text;

public class SingUpZipCodeTest extends BaseTest{

    String zipCodeInputLocator = "zip_code";
    String continueButtonlocator = "[value=Continue]";
    String errorMessageLocator = "[class='error_message']";

    @Test
    public void zipCodeShouldAccept5Digits() {
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        boolean isDisplay  = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplay, "Нужная страница не открылась");

    }

    @Test
    public void inputInZipCode5DigitsAndClickEnterOnTheKeyboard(){
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys(Keys.ENTER);
        boolean isDisplay  = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplay, "Нужная страница не открылась");

    }

    @Test
    public void inputInZipCode4Digits() {
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");

    }

    @Test
    public void doNotEnterAnythingInTheZipCode(){
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
        }

    @Test
    public void inputInZipCode5CharactersInCyrillic(){
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("абвгд");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }

    @Test
    public void inputInZipCodeSpaceAnd5Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys(" 12345");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }

    @Test
    public void inputInZipCode4DigitsAndSpace(){
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234 ");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }

    @Test
    public void zipCodeShouldAccept6Digits(){
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("123456");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }

    @Test
    public void inputInZipCode5Characters(){
        driver.get(BASE_URL+"cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("%^&*$");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }
    }