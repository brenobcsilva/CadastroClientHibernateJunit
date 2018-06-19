package CadastroCliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.cadastro.dao.DAOException;
import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src\\main\\resources\\META-INF\\springbeans.xml")
@TransactionConfiguration(transactionManager = "tm")
public class TestUsuarioDAO {

	@Autowired
	UsuarioDAO usudao;

	@Test
	public void testSalvar() {

		Usuario usu = new Usuario();
		usu.setNome("Jao");
		usu.setLogin("jao.silva");
		usu.setSenha("1234");

		usu = usudao.salvar(usu);

		Assert.assertNotNull(usu.getId());

	}

	@Test
	public void testBuscarPorId() {

		Usuario usu = new Usuario();
		usu.setNome("Jao");
		usu.setLogin("jao.silva");
		usu.setSenha("1234");

		Usuario usuSalvo = usudao.salvar(usu);

		Integer idSalvo = usuSalvo.getId();

		Usuario usuBuscado = usudao.buscarPorId(idSalvo);

		Assert.assertEquals(usuSalvo, usuBuscado);
	}

	@Test
	@Transactional
	public void testExcluir() throws DAOException {

		Usuario usu = new Usuario();
		usu.setNome("Jao");
		usu.setLogin("jao.silva");
		usu.setSenha("1234");

		Usuario usuSalvo = usudao.salvar(usu);

		usudao.excluir(usuSalvo);

		Usuario usuExcluido = usudao.buscarPorId(usuSalvo.getId());

		Assert.assertEquals(usuExcluido, null);

	}

	@Test
	public void testBuscarTodos() {

		Usuario usu = new Usuario();
		usu.setNome("Jao");
		usu.setLogin("jao.silva");
		usu.setSenha("1234");

		usudao.salvar(usu);

		List<Usuario> todos = usudao.buscarTodos();

		Assert.assertTrue(todos.size() > 0);
	}

}