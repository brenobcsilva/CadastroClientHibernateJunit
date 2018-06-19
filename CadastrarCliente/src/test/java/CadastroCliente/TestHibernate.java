package CadastroCliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.entidade.Usuario;

public class TestHibernate {

	public static void main(String[] args) {

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("fabricaweb2");
		//
		// EntityManager em = emf.createEntityManager();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");

		EntityManager em = emf.createEntityManager();

		Usuario usu = new Usuario();
		usu.setNome("Mar");
		usu.setLogin("Mar");
		usu.setSenha("Mar");
		usu.setEndereco("Mar");

		UsuarioDAO usudao = new UsuarioDAO(em);

		usudao.salvar(usu);

		// Usuario usuModificar = usudao.buscarPorId(1);
		// usuModificar.setLogin("Silva");
		// usudao.salvar(usuModificar);
		// System.out.println(usuModificar);
		//
		// usudao.excluir(usuModificar);

		ctx.close();
	}

}
