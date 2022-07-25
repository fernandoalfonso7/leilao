package leiloes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage {

    private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
    private WebDriver browser;

    public LeiloesPage(WebDriver browser){
        this.browser = browser;
        browser.manage().window().maximize();
    }

    public void fechar() {
        this.browser.quit();
    }

    public CadastroPage carregarFormulario() {
        this.browser.navigate().to(URL_CADASTRO_LEILOES);
        return new CadastroPage(browser);
    }
}

