package edu.ittj.p3.service;

/**
 * 自定义异常类
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516994229948L;

    public TeamException() {
        super();
    }

    public TeamException(String message) {
        super(message);
    }
}
