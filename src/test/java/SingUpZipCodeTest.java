import org.openqa.selenium.By;
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
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isDisplay = registerButton.isDisplayed();
        Assert.assertTrue(isDisplay, "Нужная страница не открылась");

    }
    @Test
    public void inputInZipCode4Digits() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        WebElement error_message = driver.findElement(By.cssSelector("[class='error_message']"));
        String text = error_message.getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");

    }
    @Test
    public void doNotEnterAnythingInTheZipCode(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        WebElement error_message = driver.findElement(By.cssSelector("[class='error_message']"));
        String text = error_message.getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
        }
    @Test
    public void inputInZipCode5CharactersInCyrillic(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("абвгд");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        WebElement error_message = driver.findElement(By.cssSelector("[class='error_message']"));
        String text = error_message.getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }
    @Test
    public void inputInZipCodeWhitespaceAnd5Digits(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys(" 12345");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        WebElement error_message = driver.findElement(By.cssSelector("[class='error_message']"));
        String text = error_message.getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }
    @Test
    public void inputInZipCode4DigitsAndWhitespace(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234 ");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        WebElement error_message = driver.findElement(By.cssSelector("[class='error_message']"));
        String text = error_message.getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }
    @Test
    public void zipCodeShouldAccept6Digits(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("123456");
        driver.findElement(By.cssSelector(continueButtonlocator)).click();
        WebElement error_message = driver.findElement(By.cssSelector("[class='error_message']"));
        String text = error_message.getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Не верный текст сообщения");
    }
    }