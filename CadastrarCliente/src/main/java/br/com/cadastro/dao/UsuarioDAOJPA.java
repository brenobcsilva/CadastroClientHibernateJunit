package br.com.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cadastro.entidade.Usuario;

@Repository
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	public UsuarioDAOJPA(EntityManager em) {
		this.em = em;
	}

	public UsuarioDAOJPA() {

	}

	public void cadastrar(Usuario usu) {
		em.persist(usu);
	}

	public void alterar(Usuario usu) {

	}

	@Transactional
	public Usuario salvar(Usuario usu) {
		Usuario u = em.merge(usu);
		return u;
	}

	@Transactional
	public void excluir(Usuario usu) {
		try {
			em.remove(usu);
		} catch (Exception e) {
			// throw new DAOException("Não foi possivel excluir: ", e);
		}
	}

	public void excluir2(Usuario usu) {
		em.remove(usu);
	}

	public Usuario buscarPorId(int id) {
		return em.find(Usuario.class, id);
	}

	public List<Usuario> buscarTodos() {
		Query q = em.createQuery("select u from Usuario u");
		return q.getResultList();
	}

	@Override
	public Usuario buscarLogin(String login) {
		try {
			Query q = em.createQuery("select u from Usuario u where u.login=:loginParam");
			q.setParameter("loginParam", login);
			q.setMaxResults(1);
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			// throw new DAOException("Registro não encontrado", e);
		}

	}

}
