package com.edfeff.clazz.parser.constant;

/**
 * 常量池
 * long 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpLong extends Constant {
    private long value;

    public CpLong(long value) {
        this.tag = CONSTANT_LONG;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Long: " + value;
    }
}
