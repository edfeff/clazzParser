package com.example.clazz.parser.constant;

/**
 * 常量池 基础抽象类
 *
 * @author wpp
 * @date 2019-03-08
 */
public abstract class Constant {
    protected byte tag;

    public byte getTag() {
        return tag;
    }

    public final static byte CONSTANT_CLASS = 7;
    public final static byte CONSTANT_FIELDREF = 9;
    public final static byte CONSTANT_METHODREF = 10;
    public final static byte CONSTANT_INTERFACEMETHODREF = 11;
    public final static byte CONSTANT_STRING = 8;
    public final static byte CONSTANT_INTEGER = 3;
    public final static byte CONSTANT_FLOAT = 4;
    public final static byte CONSTANT_LONG = 5;
    public final static byte CONSTANT_DOUBLE = 6;
    public final static byte CONSTANT_NAMEANDTYPE = 12;
    public final static byte CONSTANT_UTF8 = 1;
    public final static byte CONSTANT_METHODHANDLE = 15;
    public final static byte CONSTANT_METHODTYPE = 16;
    public final static byte CONSTANT_INVOKEDYNAMIC = 18;
}
