package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class Post extends Base {
    private Base base;

    public Post(Base base) {

        this.base = base;
    }

    @Dado("^que acesso a Wikipedia em Portugues$")
    public void queAcessoAWikipediaEmPortugues() {
        base.driver.get(base.url);     // Abre o navegador no site alvo (extendendo a base)
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String produto) {
        base.driver.findElement(By.id("searchInput")).sendKeys(produto + Keys.ENTER);
    }

    @Entao("^Exibe a expressão \"([^\"]*)\" no titulo da guia$")
    public void exibeAExpressaoNoTituloDaGuia(String produto) {
        //WebDriverWait wait = new WebDriverWait(base.driver, 6);
        //wait.until(ExpectedConditions.titleIs(produto + " - Wikipédia, a enciclopédia livre"));
        assertTrue(base.driver.getTitle().contains(produto));
    }
}
