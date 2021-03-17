package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Artigo {
    String url;             // Endere�o do site alvo
    WebDriver driver;       // Objeto do selenium WebDriver

    @Before                 // Antes do Teste
    public void iniciar(){
        url = "https://pt.wikipedia.org/";
        // Local onde est� o Chrome Driver
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/89/chromedriver.exe");
        driver = new ChromeDriver(); // Instanciar o Selenium como Chrome Drive
        driver.manage().window().maximize(); // Maximizar a janela do navegador
        // Define uma espera implicita de 1min, verificando o carregamento a cada milissegundo
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }

    @Test
    public void consultarArtigo(){
        // Abrir o Site
        driver.get(url);
        // Pesquisar por "Ovo de P�scoa"
        driver.findElement(By.id("searchInput")).sendKeys("Ovo de P�scoa");
        driver.findElement(By.id("searchButton")).click();  // C lica na lupa
        // Validar o t�tulo da p�gina de retorno
        //assertEquals("Ovo de P�scoa � Wikip�dia, a enciclop�dia livre", driver.getTitle());
        assertTrue(driver.getTitle().contains("Ovo de P�scoa"));

    }

    @After
    public void finalizar(){
        driver.quit();
    }
}
