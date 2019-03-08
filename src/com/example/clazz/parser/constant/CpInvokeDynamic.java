package com.example.clazz.parser.constant;

/**
 * 常量池
 * 动态调用 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpInvokeDynamic extends Constant {
    private short bootstrapMethodAttrIndex;
    private short nameAndTypeIndex;

    public CpInvokeDynamic(short bootstrapMethodAttrIndex, short nameAndTypeIndex) {
        this.tag = CONSTANT_INVOKEDYNAMIC;
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public short getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }


    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "InvokeDynamic, bootstrapMethodAttrIndex: " + this.bootstrapMethodAttrIndex + " nameAndTypeIndex: " + this.nameAndTypeIndex;
    }
}
