package br.com.projeto.ecommerce.exception;

import org.hibernate.service.spi.ServiceException;

import java.security.Provider;

public class ProductInsertException extends ServiceException {

    public ProductInsertException(String message, Throwable root) {
        super(message, root);
    }

    public ProductInsertException(String message) {
        super(message);
    }
}
