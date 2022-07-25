package login;

import leiloes.LeiloesPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    public static final String URL_LOGIN = "http://localhost:8080/login";
    public WebDriver browser;

    public LoginPage(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void login(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage submete() {
        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public String usuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void paginaLances() {
       browser.navigate().to("http://localhost:8080/leloes/2");
    }

   public boolean isPaginaDeLoginInvalido() {
        return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }
}

