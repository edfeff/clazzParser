package com.example.clazz.parser.constant;

/**
 * 常量池
 * class常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpClass extends Constant {
    private short nameIndex;

    public CpClass(short nameIndex) {
        this.tag = Constant.CONSTANT_CLASS;
        this.nameIndex = nameIndex;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    @Override
    public String toString() {
        return "Class Index: " + nameIndex;
    }
}
