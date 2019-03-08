package com.example.clazz.parser.constant;

/**
 * 常量池
 * double常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpDouble extends Constant {
    private double value;

    public CpDouble(double value) {
        this.tag = CONSTANT_DOUBLE;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Double: " + this.value;
    }
}
