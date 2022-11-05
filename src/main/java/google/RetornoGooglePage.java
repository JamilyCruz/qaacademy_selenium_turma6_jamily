package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;


public class RetornoGooglePage {
   String textoRetorno = "//*[@id=\"sports-app\"]/div/div[1]/div/div/div[1]/div/div[2]/div[2]";

   public void validarRetornoBusca(WebDriver driver){
       driver.findElement(By.xpath(textoRetorno));
       Assert.assertEquals("Sport Club Corinthians Paulista", textoRetorno);
   }
}
