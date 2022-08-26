package br.com.projeto.ecommerce.exception;

import org.hibernate.service.spi.ServiceException;

public class ProductNotRegisteredException extends ServiceException {

    public ProductNotRegisteredException(String message) {
        super(message);
    }

    public ProductNotRegisteredException(String message, Throwable thr){
        super(message, thr);
    }
}
