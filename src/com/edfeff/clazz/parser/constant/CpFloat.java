package com.edfeff.clazz.parser.constant;

/**
 * 常量池
 * float 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpFloat extends Constant {
    private float value;

    public CpFloat(float value) {
        this.tag = Constant.CONSTANT_FLOAT;
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Float: " + this.value;
    }
}
