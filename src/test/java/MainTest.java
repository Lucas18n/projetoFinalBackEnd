import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:4200/products");
            driver.manage().window().maximize();

            // Clica no botão Novo Produto
            WebElement btnNovoProduto = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Novo Produto')]")));
            btnNovoProduto.click();

            // Preenche os inputs pelo atributo name
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("proNome"))).sendKeys("Produto");
            driver.findElement(By.name("proPrecoCusto")).sendKeys("10.50");
            driver.findElement(By.name("proPrecoVenda")).sendKeys("20.00");
            driver.findElement(By.name("quantidadeEstoque")).sendKeys("100");
            driver.findElement(By.name("codigoBarras")).sendKeys("1234567890123");
            driver.findElement(By.name("marca")).sendKeys("Marca Teste");
            driver.findElement(By.name("unidadeMedida")).sendKeys("Un");

            // Clica no select de Categoria
            WebElement categoriaSelect = driver.findElement(By.name("categoria"));
            categoriaSelect.click();

// Aguarda o carregamento das opções
            List<WebElement> opcoesCategoria = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("mat-option")));

            if (opcoesCategoria.size() >= 2) {
                opcoesCategoria.get(1).click(); // Segunda opção (índice 1)
            } else {
                System.out.println("Não há duas categorias disponíveis.");
            }


            // Seleciona a opção do mat-select "Produto Ativo?"
            WebElement ativoSelect = driver.findElement(By.cssSelector("mat-form-field mat-select[name='ativo']"));
            ativoSelect.click();

            // Seleciona "Sim" (valor true)
            WebElement opcaoSim = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//mat-option[.//span[contains(text(),'Sim')]]")));
            opcaoSim.click();


            // Clica no botão Salvar
            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/button[1]"));
            btnSalvar.click();

            // Só pra ver o resultado antes de fechar
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
