package ru.election.util.exception;

public class IllegalRequestDataException extends RuntimeException {

    public IllegalRequestDataException (String massage) {
        super(massage);
    }
}