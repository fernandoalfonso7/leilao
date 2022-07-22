import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static final String URL_LOGIN = "http://localhost:8080/login";
    public WebDriver browser;

    @BeforeClass
    public static  void beforeClass(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
    }

    @Before
    public void before(){
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.navigate().to(URL_LOGIN);
    }

    @After
    public  void after(){
        this.browser.quit();
    }

    @Test
    public void loginValidos(){
        loginValido();

        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
    }

    private void loginValido() {
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();
    }

    @Test
    public  void loginInvalido(){
        browser.findElement(By.id("username")).sendKeys("invalido");
        browser.findElement(By.id("password")).sendKeys(("erro"));
        browser.findElement(By.id("login-form")).submit();

        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
        Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assert.assertThrows(NoSuchElementException.class, () ->browser.findElement(By.id("usuario-logado")));
    }

    @Test
    public  void paginaRestrita() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");

        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
    }

}
