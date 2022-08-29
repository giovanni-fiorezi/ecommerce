package br.com.projeto.ecommerce.exception;

import org.hibernate.service.spi.ServiceException;

public class EcommerceException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public EcommerceException(String message) {
		super(message);
	}

	public EcommerceException(String message, Throwable thr) {
		super(message, thr);
	}
}
