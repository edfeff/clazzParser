package com.example.clazz.parser.constant;
/**
 * 常量池
 * string 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpString extends Constant {

    private short stringIndex;

    public CpString(short stringIndex) {
        this.tag = Constant.CONSTANT_STRING;
        this.stringIndex = stringIndex;
    }

    public short getStringIndex() {
        return stringIndex;
    }

    @Override
    public String toString() {
        return "String , stringIndex: " + stringIndex;
    }
}
