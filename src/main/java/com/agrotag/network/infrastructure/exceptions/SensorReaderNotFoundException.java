package com.agrotag.network.infrastructure.exceptions;

public class SensorReaderNotFoundException extends RuntimeException {
    public SensorReaderNotFoundException(String message) {
        super(message);
    }
}
