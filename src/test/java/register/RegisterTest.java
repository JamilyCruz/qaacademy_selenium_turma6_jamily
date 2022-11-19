package register;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    @Before
    public void iniciar(){
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
    }

    @Test
    public void register(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).sendKeys("Jamily");
        driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]")).sendKeys("Cruz");
        driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("jamily@gmail.com");
        driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]")).sendKeys("11965421600");
        driver.findElement(By.name("radiooptions")).click();
        driver.findElement(By.id("checkbox2")).click();
        driver.findElement(By.id("msdd")).click();
        Select select1 = new Select(driver.findElement(By.id("Skills")));
        select1.selectByVisibleText("Android");
        Select select2 = new Select(driver.findElement(By.id("countries")));
        select2.selectByVisibleText("Select Country");
        Select select4 = new Select(driver.findElement(By.id("yearbox")));
        select4.selectByVisibleText(("1986"));
        Select select5 = new Select(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[11]/div[2]/select[1]")));
        select5.selectByVisibleText(("February"));
        Select select6 = new Select(driver.findElement(By.id("daybox")));
        select6.selectByVisibleText(("14"));
        driver.findElement(By.id("firstpassword")).sendKeys("Padrao@123");
        driver.findElement(By.id("secondpassword")).sendKeys("Padrao@123");

    }
    @Test
    public void RegisterPage(){
        RegisterPage registerPage = new RegisterPage();
        registerPage.preencherNome(driver);
        registerPage.preencherSobreNome(driver);
        registerPage.preencherEmail(driver);
        registerPage.preencherTelefone(driver);
        registerPage.selecionarGenero(driver);
        registerPage.clicarHobbie(driver);
        registerPage.selecionarSkill(driver);
        registerPage.selecionarCountries(driver);

    }
}
