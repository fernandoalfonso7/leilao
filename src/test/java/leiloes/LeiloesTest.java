package login;

import leiloes.CadastroPage;
import leiloes.LeiloesPage;
import login.LoginPage;
import org.junit.*;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;

    @After
    public void after(){
        this.paginaDeLeiloes.fechar();
    }

    @Test
    public void cadastrarLeilao(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.login("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.submete();
        CadastroPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
    }
}
