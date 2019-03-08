package com.edfeff.clazz.parser.constant;

/**
 * 常量池
 * 方法句柄 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpMethodHandle extends Constant {
    private byte referenceKind;
    private short referenceIndex;

    public CpMethodHandle(byte referenceKind, short referenceIndex) {
        this.tag = CONSTANT_METHODHANDLE;
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public short getReferenceIndex() {
        return referenceIndex;
    }

    @Override
    public String toString() {
        return "MethodHandle: " + this.referenceIndex;
    }
}
