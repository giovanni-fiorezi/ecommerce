package br.com.projeto.ecommerce.exception;

import org.hibernate.service.spi.ServiceException;

public class ProductException extends ServiceException {

    private static final long serialVersionUID = 1L;

	public ProductException(String message, Throwable root) {
        super(message, root);
    }

    public ProductException(String message) {
        super(message);
    }
}
