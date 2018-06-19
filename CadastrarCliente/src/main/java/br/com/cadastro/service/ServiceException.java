package br.com.cadastro.service;

public class ServiceException extends Exception {

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	
	
}
