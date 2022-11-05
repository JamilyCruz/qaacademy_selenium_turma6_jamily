package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuscaGooglePage {
    private String campoBusca = "q";
    private String resultadoBusca = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[3]/div[2]/div[2]/ul[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/span[1]";

    public void preencherCampoBusca(WebDriver driver){
        driver.findElement(By.name(campoBusca)).sendKeys("Jogos do Corinthians");
    }

    public void clicarResultadoBusca(WebDriver driver){
        driver.findElement(By.xpath(resultadoBusca)).click();
    }

}
