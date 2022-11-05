package janela;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JanelaTest2 {
    WebDriver driver;

    @Before
    public void iniciaTeste(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();
    }

    @Test
    public void janela2(){
        driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
        Object[] janelas = driver.getWindowHandles().toArray();
        driver.switchTo().window(janelas[1].toString());
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/", url);
    }
}
