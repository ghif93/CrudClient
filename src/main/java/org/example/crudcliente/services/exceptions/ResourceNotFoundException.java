package org.example.crudcliente.services.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
