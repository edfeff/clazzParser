package com.edfeff.clazz.parser.constant;

/**
 * 常量池
 * 接口方法引用 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpInterfaceMethodref extends Constant {
    private short classIndex;
    private short nameAndTypeIndex;

    public CpInterfaceMethodref(short classIndex, short nameAndTypeIndex) {
        this.tag = Constant.CONSTANT_INTERFACEMETHODREF;
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
        return "InterfaceMethod ref, classIndex: " + this.classIndex + " nameAndTypeIndex: " + this.nameAndTypeIndex;
    }
}
