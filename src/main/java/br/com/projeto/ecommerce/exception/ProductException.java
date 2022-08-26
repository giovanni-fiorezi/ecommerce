package br.com.projeto.ecommerce.exception;

import org.hibernate.service.spi.ServiceException;

public class ProductException extends ServiceException {

    public ProductException(String message, Throwable root) {
        super(message, root);
    }

    public ProductException(String message) {
        super(message);
    }
}
