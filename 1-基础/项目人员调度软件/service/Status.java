package edu.ittj.p3.service;

/**
 * 表达员工的3中状态
 */
public class Status {
    public final String NAME;
    private Status(String name){
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }

}
