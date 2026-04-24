package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class CadastroPage {

    private WebDriver navegador;


    public CadastroPage (WebDriver navegador){
        this.navegador = navegador;
    }
    Faker faker = new Faker(new Locale("pt-BR"));
    String primeiroNome = faker.name().firstName();
    String sobrenome = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(12, 15, true, true, true);

    public CadastroPage realizarCadastro(){

        //create account
        System.out.println("######## Preenchendo cadastro ################");
        navegador.get("https://magento2-demo.magebit.com/customer/account/create/");
        navegador.findElement(By.id("firstname")).sendKeys(primeiroNome);
        navegador.findElement(By.id("lastname")).sendKeys(sobrenome);
        navegador.findElement(By.id("email_address")).sendKeys(email);
        navegador.findElement(By.id("password")).sendKeys(password);
        navegador.findElement(By.id("password-confirmation")).sendKeys(password);


        return this;

    }

    public CadastroPage submeterCadastro(){
        navegador.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();

        return this;
    }

}
