package cep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuscaCepPage {
    private String campoBusca = "endereco";
    private String pesquisar = "btn_pesquisar";

    public void preencherCampoBusca(WebDriver driver){
        driver.findElement(By.name(campoBusca)).sendKeys("06045420");
    }
    public void clicarResultadoBusca(WebDriver driver){
        driver.findElement(By.id(pesquisar)).click();
    }

}
