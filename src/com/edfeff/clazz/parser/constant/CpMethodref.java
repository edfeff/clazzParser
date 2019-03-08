package com.edfeff.clazz.parser.constant;

/**
 * 常量池
 * 方法引用 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpMethodref extends Constant {
    private short classIndex;
    private short nameAndTypeIndex;

    public CpMethodref(short classIndex, short nameAndTypeIndex) {
        this.tag = Constant.CONSTANT_METHODREF;
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public short getClassIndex() {
        return classIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "Method ref,classIndex: " + this.classIndex + " nameAndTypeIndex: " + this.nameAndTypeIndex;
    }
}
