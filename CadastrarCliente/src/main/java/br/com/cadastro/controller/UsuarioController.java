package br.com.cadastro.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Controller;

import br.com.cadastro.entidade.Usuario;

@ManagedBean
public class UsuarioController {

	Usuario usu = new Usuario();
	
	public void salvar() {
		System.out.println(usu);
	}
	
}
