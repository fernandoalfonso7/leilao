package login;

import login.LoginPage;
import org.junit.*;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @Before
    public void before(){
        this.paginaDeLogin = new LoginPage();
        }

    @After
    public void after(){
        this.paginaDeLogin.fechar();
        }

    @Test
    public void loginValido() {
        paginaDeLogin.login("fulano", "pass");
        paginaDeLogin.submete();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals("fulano", paginaDeLogin.usuarioLogado());
        }


    @Test
    public void loginInvalido(){
        paginaDeLogin.login("invalido", "erro");
        paginaDeLogin.submete();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginInvalido());
        Assert.assertNull(" ", paginaDeLogin.usuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
        }

    @Test
    public void paginaRestrita() {
        paginaDeLogin.paginaLances();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }

}
