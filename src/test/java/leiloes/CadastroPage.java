package leiloes;

import org.openqa.selenium.WebDriver;

public class CadastroPage {

    private WebDriver browser;

    public CadastroPage(WebDriver browser){
        this.browser = browser;
    }

    public void fechar() {
        this.browser.quit();
    }

}

