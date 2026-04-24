package cadastro;


import Pages.CadastroPage;
import Pages.Checkout;
import Pages.LoginPage;
import Pages.ProdutoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


@DisplayName("Teste web Magento")

public class MagentoTest {


    private WebDriver navegador;

@BeforeEach
public void beforeEach(){
    //Gerar dados para realizar cadastro
    navegador = new ChromeDriver();
    navegador.manage().window().maximize();
    navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    navegador.get("https://magento2-demo.magebit.com/");
}
    @Test
    // Realizar cadastro
    public void realizarCadatrado() throws InterruptedException {
        new CadastroPage(navegador)
                .realizarCadastro()
                .submeterCadastro();

        new LoginPage(navegador)
                .realizarLogin()
                .comprarProduto();

        new Checkout(navegador)
                .realizarCompra()
                .confirmarPagamento();

        System.out.println("######## Finalizando teste ################");
        navegador.quit();
    }
}