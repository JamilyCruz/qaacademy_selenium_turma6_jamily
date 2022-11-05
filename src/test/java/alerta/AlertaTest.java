package alerta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.time.Duration;

public class AlertaTest {
    WebDriver driver;
    @Before
    public void iniciar() {
        driver = new ChromeDriver();
        driver.get("https://automacaocombatista.herokuapp.com/mudancadefoco/alert");
        driver.manage().window().maximize();
    }
    @Test
    public void alerta(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]/button[1]")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        Assert.assertEquals("Eu sou um alerta JS!", text);
        alert.accept();
        //alert.dismiss();
    }
}