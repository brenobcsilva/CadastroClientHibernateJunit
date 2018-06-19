package br.com.cadastro.dao;

public class DAOException extends Exception {

	public DAOException(String msg, Exception causa) {
		super(msg, causa);
	}

}
