package ru.javastudy.springMVC.model.exception;

/**
 * Created by User on 04.11.2016.
 */
public class FileFormatException extends Exception {
    public FileFormatException()
    {
        super();
    }
    public FileFormatException(String message)
    {
        super(message);
    }
}
