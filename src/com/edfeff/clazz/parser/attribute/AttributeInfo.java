package com.edfeff.clazz.parser.attribute;

/**
 * 属性类
 *
 * @author wpp
 * @date 2019-03-08
 */
public class AttributeInfo {
    private short attributeNameIndex;
    private int attributeLength;
    private byte[] info;

    public AttributeInfo(short attributeNameIndex, int attributeLength, byte[] info) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.info = info;
    }

    public byte[] getInfo() {
        return info;
    }
}
