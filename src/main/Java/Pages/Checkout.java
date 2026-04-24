package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Checkout {


    private WebDriver navegador;
    private CadastroPage cadastro;
    private LoginPage login;
    private ProdutoPage produto;

    public Checkout(WebDriver navegador) {
        this.navegador = navegador;
    }


    public Checkout realizarCompra() throws InterruptedException {

        System.out.println("######## Iniciando checkout ################");
        navegador.get("https://magento2-demo.magebit.com/checkout/#shipping");

        // Clicar e preencher endereço
        navegador.findElement(By.name("street[0]")).click();
        navegador.findElement(By.name("street[0]")).sendKeys("John Doe");

        navegador.findElement(By.name("street[1]")).click();
        navegador.findElement(By.name("street[1]")).sendKeys("123 Main St");

        navegador.findElement(By.name("street[2]")).click();
        navegador.findElement(By.name("street[2]")).sendKeys("Apt 4B");

        WebElement comboElemento = navegador.findElement(By.name("region_id"));
        Select dropdown = new Select(comboElemento);
        dropdown.selectByVisibleText("Florida");

        navegador.findElement(By.name("city")).sendKeys("Miami");
        navegador.findElement(By.name("postcode")).sendKeys("12345-6789");
        navegador.findElement(By.name("telephone")).sendKeys("123555789");

        navegador.findElement(By.name("ko_unique_1")).click();
        Thread.sleep(3000);
        navegador.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();

        return this;
    }

    public Checkout confirmarPagamento(){
        // Confirmar pagamento

        System.out.println("######## Finalizando pagamento ################");
        try {
            WebElement elemento = navegador.findElement(By.xpath("//span[text()='Place Order']"));
            ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", elemento);
        } catch (Exception e) {
            // Caso o span falhe, tenta pelo título do button
            WebElement button = navegador.findElement(By.cssSelector("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button"));
            ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", button);
        }

        System.out.println("Pedido realizado com sucesso!");
        return this;
    }
}
