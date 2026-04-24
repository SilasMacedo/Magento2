package Pages;

import cadastro.MagentoTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage {

    private WebDriver navegador;
    private MagentoTest teste;
    private CadastroPage cadastro;
    private LoginPage login;


    public ProdutoPage (WebDriver navegador){

        this.navegador = navegador;
    }

    public Checkout comprarProduto(){

        // Buscar produto
        System.out.println("######## Buscando produto ################");
        navegador.get("https://magento2-demo.magebit.com/");
        navegador.findElement(By.id("search")).sendKeys("Fusion Backpack");
        navegador.findElement(By.id("search")).submit();
        navegador.findElement(By.className("product-image-photo")).isEnabled();
        navegador.findElement(By.className("product-image-photo")).click();
        navegador.findElement(By.id("product-addtocart-button")).isEnabled();
        navegador.findElement(By.id("product-addtocart-button")).submit();

        return new Checkout(navegador);
    }

}
