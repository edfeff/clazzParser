package com.example.clazz.parser.access;

/**
 * Class 访问控制标识枚举
 *
 * @author wpp
 * @date 2019-03-08
 */
public enum ClazzAccessFlag {
    ACC_PUBLIC(0x0001),//1          0000000000000001
    ACC_FINAL(0x0010), //16         0000000000010000‬
    ACC_SUPER(0x0020),//32          00000000‭00100000‬
    ACC_INTERFACE(0x0200),//512     ‭0000001000000000‬
    ACC_ABSTRACT(0x0400),//1024     ‭0000010000000000‬
    ACC_SYNTHETIC(0x1000),//4096    ‭0001000000000000‬
    ACC_ANNOTATION(0x2000),//8192   ‭0010000000000000‬
    ACC_ENUM(0x4000);//16384        0100000000000000

    private int value;

    ClazzAccessFlag(int value) {
        this.value = value;
    }

    public static ClazzAccessFlag getAccessFlag(int value) {
        if (value == ACC_PUBLIC.value) {
            return ACC_PUBLIC;
        } else if (value == ACC_FINAL.value) {
            return ACC_FINAL;
        } else if (value == ACC_SUPER.value) {
            return ACC_SUPER;
        } else if (value == ACC_INTERFACE.value) {
            return ACC_INTERFACE;
        } else if (value == ACC_ABSTRACT.value) {
            return ACC_ABSTRACT;
        } else if (value == ACC_SYNTHETIC.value) {
            return ACC_SYNTHETIC;
        } else if (value == ACC_ANNOTATION.value) {
            return ACC_ANNOTATION;
        } else if (value == ACC_ENUM.value) {
            return ACC_ENUM;
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
