package br.com.projeto.ecommerce.exception;

import org.hibernate.service.spi.ServiceException;

public class ProductNotRegisteredException extends ServiceException {

    private static final long serialVersionUID = 1L;

	public ProductNotRegisteredException(String message) {
        super(message);
    }

    public ProductNotRegisteredException(String message, Throwable thr){
        super(message, thr);
    }
}
