package com.shanuka.ecom.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)    // use to call the superclass of the CustomerNotFoundException
@Data
public class CustomerNotFoundException extends RuntimeException {

    private final String msg;

}
