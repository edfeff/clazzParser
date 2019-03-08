package com.edfeff.clazz.parser.constant;

/**
 * 常量池
 * integer 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpInteger extends Constant {
    private int bytes;

    public CpInteger(int bytes) {
        this.tag = Constant.CONSTANT_INTEGER;
        this.bytes = bytes;
    }

    public int getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        return "Integer: " + bytes;
    }
}
