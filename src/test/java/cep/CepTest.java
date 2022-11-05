package cep;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CepTest {

    WebDriver driver;
@Before
public void iniciar(){
    driver = new ChromeDriver();
    driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void buscaCep() throws InterruptedException {
        BuscaCepPage buscaCepPage = new BuscaCepPage();
        buscaCepPage.preencherCampoBusca(driver);
        buscaCepPage.clicarResultadoBusca(driver);
        RetornoCepPage retornoCepPage = new RetornoCepPage();
        retornoCepPage.validarRetornoBusca(driver);

    }

    @Test
    public void selecao() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("tipoCEP")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/select[1]/optgroup[1]/option[1]")).click();
        driver.findElement(By.id("endereco")).sendKeys("Via Transversal Sul");
        driver.findElement(By.id("btn_pesquisar")).click();
        String rua = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[2]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
        Assert.assertEquals("Via Transversal Sul", rua);
        String bairro = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[2]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
        Assert.assertEquals("Novo Osasco", bairro);
        String localizade = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[2]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        Assert.assertEquals("Osasco/SP", localizade);
        String cep = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[2]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[4]")).getText();
        Assert.assertEquals("06045-420", cep);
    }

    @Test
    public void erro() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/select[1]/optgroup[1]/option[3]")).click();
        driver.findElement(By.id("endereco")).sendKeys("06045420");
        driver.findElement(By.id("btn_pesquisar")).click();
        String mensagem = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[2]/div[1]/div[3]/h6[1]")).getText();
        Assert.assertEquals("Dados não encontrado", mensagem);
    }
    @After
    public void fecharBrowser(){
        driver.quit();
    }

}
