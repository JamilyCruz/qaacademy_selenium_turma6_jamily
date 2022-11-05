package janela;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JanelaTest {
    WebDriver driver;
    @Before
    public void iniciar() {
        driver = new ChromeDriver();
        driver.get("https://automacaocombatista.herokuapp.com/mudancadefoco/janela");
        driver.manage().window().maximize();
    }

    @Test
        public void janela(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/a[1]")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        String texto = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/h5[1]")).getText();
        Assert.assertEquals("Você Abriu uma nova janela!!", texto);
    }
}
