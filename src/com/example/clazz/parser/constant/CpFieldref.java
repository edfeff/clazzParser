package com.example.clazz.parser.constant;

/**
 * 常量池
 * Field引用 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpFieldref extends Constant {
    private short classIndex;
    private short nameAndTypeIndex;

    public CpFieldref(short classIndex, short nameAndTypeIndex) {
        this.tag = Constant.CONSTANT_FIELDREF;
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
        return "Field ref, classIndex: " + this.classIndex + " nameAndTypeIndex: " + this.nameAndTypeIndex;
    }
}
