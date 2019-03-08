package com.edfeff.clazz.parser.constant;

/**
 * 常量池
 * 方法类型 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpMethodType extends Constant {
    private short descriptorIndex;

    public CpMethodType(short descriptorIndex) {
        this.tag = CONSTANT_METHODTYPE;
        this.descriptorIndex = descriptorIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public String toString() {
        return "MethodType, descriptorIndex: " + descriptorIndex;
    }
}
