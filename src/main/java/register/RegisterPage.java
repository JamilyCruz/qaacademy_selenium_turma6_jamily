package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private String nome = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]";
    private String sobreNome = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]";
    private String email = "//*[@id=\"eid\"]/input";
    private String telefone = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]";
    private String selGenero = "radiooptions";
    private String selHobbies = "checkbox2";
    private String selSkill = "Skills";
    private String selCountries = "countries";


    public void preencherNome(WebDriver driver){
        driver.findElement(By.xpath(nome)).sendKeys("Jamily");
    }
    public void preencherSobreNome(WebDriver driver){
        driver.findElement(By.xpath(sobreNome)).sendKeys("Cruz");
    }
    public void preencherEmail(WebDriver driver){
        driver.findElement(By.xpath(email)).sendKeys("jamily1402@gmail.com");
    }
    public void preencherTelefone(WebDriver driver){
        driver.findElement(By.xpath(telefone)).sendKeys("11 965421608");
    }
    public void selecionarGenero(WebDriver driver){
        driver.findElement(By.name(selGenero)).click();
    }
    public void clicarHobbie(WebDriver driver){
        driver.findElement(By.id(selHobbies)).click();
    }
    public void selecionarSkill(WebDriver driver){
        Select select1 = new Select(driver.findElement(By.id(selSkill)));
        select1.selectByVisibleText("Android");
    }
    public void selecionarCountries(WebDriver driver){
        Select select2 = new Select(driver.findElement(By.id(selCountries)));
        select2.selectByVisibleText("Select Country");
    }

}



