package com.example.clazz.parser.constant;

/**
 * 常量池
 * 名称和类型 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpNameAndType extends Constant {
    private short nameIndex;
    private short descriptorIndex;

    public CpNameAndType(short nameIndex, short descriptorIndex) {
        this.tag = Constant.CONSTANT_NAMEANDTYPE;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public String toString() {
        return "NameAndType, nameIndex:" + this.nameIndex + " descriptorIndex:" + descriptorIndex;
    }
}
