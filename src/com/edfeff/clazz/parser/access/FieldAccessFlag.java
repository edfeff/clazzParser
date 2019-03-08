package com.edfeff.clazz.parser.access;

/**
 * 字段 访问控制标识枚举
 *
 * @author wpp
 * @date 2019-03-08
 */
public enum FieldAccessFlag {

    ACC_PUBLIC(0x0001),
    ACC_PRIVATE(0x0002),
    ACC_PROTECTED(0x0004),
    ACC_STATIC(0x0008),
    ACC_FINAL(0x0010),
    ACC_VOLATILE(0x0040),
    ACC_TRANSIENT(0x0080),
    ACC_SYNTHETIC(0x1000),
    ACC_ENUM(0x4000);

    private int value;

    FieldAccessFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
