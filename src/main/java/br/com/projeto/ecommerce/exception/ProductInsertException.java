package br.com.projeto.ecommerce.exception;

import org.hibernate.service.spi.ServiceException;

public class ProductInsertException extends ServiceException {

    private static final long serialVersionUID = 1L;

	public ProductInsertException(String message, Throwable root) {
        super(message, root);
    }

    public ProductInsertException(String message) {
        super(message);
    }
}
