package br.com.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.entidade.Usuario;

@Service
public class UsuarioService {

	@Autowired
	@Qualifier(value="usuarioDAOJPA")
	UsuarioDAO usudao;

	public Usuario salvar(Usuario usu) throws ServiceException {

		Usuario usuExistente = usudao.buscarLogin(usu.getLogin());
		if (usuExistente != null) {
			throw new ServiceException("Usuário já existe!");
		}
		return usudao.salvar(usu);
	}
	
	public void excluir(Usuario usu) throws ServiceException {
		try {
			usudao.excluir(usu);	
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	public Usuario buscarPorId(int id) {
		return usudao.buscarPorId(id);
	}
	
	public List<Usuario> buscarTodos(){
		return usudao.buscarTodos();
	}
	
	public Usuario buscarLogin(String login) {
		return usudao.buscarLogin(login);
	}

}
