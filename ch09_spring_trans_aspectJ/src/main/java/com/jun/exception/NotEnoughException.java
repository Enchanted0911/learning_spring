package com.jun.exception;

/**
 * 自定义运行时异常
 * @author Wu
 */
public class NotEnoughException extends RuntimeException {
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
