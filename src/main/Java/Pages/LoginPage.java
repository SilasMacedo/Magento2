package Pages;

import cadastro.MagentoTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {


    private WebDriver navegador;
    private MagentoTest teste;
    private ProdutoPage produto;

    CadastroPage cadastro = new CadastroPage(navegador);


    public LoginPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public ProdutoPage realizarLogin(){

        System.out.println("######## Realizando login ################");
        navegador.get("https://magento2-demo.magebit.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvMi1kZW1vLm1hZ2ViaXQuY29tLw%2C%2C/");
        navegador.findElement(By.name("email")).sendKeys(cadastro.email);
        navegador.findElement(By.name("login[password]")).sendKeys(cadastro.password);
        navegador.findElement(By.name("send")).submit();

        return new ProdutoPage(navegador);
    }

}
