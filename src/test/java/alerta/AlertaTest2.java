package alerta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertaTest2 {
    WebDriver driver;

    @Before
    public void iniciaTeste(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void testesAlertasSimples() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        Assert.assertEquals("I am an alert box!", mensagemAlerta);
        alert.accept();
    }

    @Test
    public void testAlertaOkCancel() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals("Press a Button !", mensagemAlerta);
        alert.dismiss();
    }

    @Test
    public void testAlertaTextBox() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("Teste TextBox");
        alert.accept();
        String mensagem = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        Assert.assertTrue(mensagem.contains("Teste TextBox"));
        //Assert.assertEquals("Hello Teste TextBox How are you today", mensagem);
    }
}
