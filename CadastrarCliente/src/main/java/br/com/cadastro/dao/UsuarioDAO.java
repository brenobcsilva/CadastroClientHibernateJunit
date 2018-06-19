package br.com.cadastro.dao;

import java.util.List;

import br.com.cadastro.entidade.Usuario;

public interface UsuarioDAO {

	public Usuario salvar(Usuario usu);

	public void excluir(Usuario usu);

	public Usuario buscarPorId(int id);

	public List<Usuario> buscarTodos();

	public Usuario buscarLogin(String login);

}
