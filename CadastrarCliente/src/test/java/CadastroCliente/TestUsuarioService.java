package CadastroCliente;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.entidade.Usuario;
import br.com.cadastro.service.ServiceException;
import br.com.cadastro.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestUsuarioService {

	@Autowired
	UsuarioService usuService;

	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuarioDAO;

	@Transactional
	@Test(expected = ServiceException.class)
	public void testNaoDeveSalvar() throws ServiceException {
		Usuario usu = new Usuario();
		usu.setLogin("testsalvar1");
		usu.setSenha("123");
		usu.setNome("Test Nome");

		usuarioDAO.salvar(usu);

		Usuario usuSalvo;

		usuService.salvar(usu);
	}

	@Transactional
	@Test
	public void testDeveSalvar() throws ServiceException {

		Usuario usu = new Usuario();
		usu.setLogin("novoUsuario1");
		usu.setSenha("1231");
		usu.setNome("novo Nome1");

		usuService.salvar(usu);
	}
}
