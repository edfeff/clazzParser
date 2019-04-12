package com.edfeff.clazz.parser.constant;

import java.nio.charset.Charset;

/**
 * 常量池
 * utf8 常量
 *
 * @author wpp
 * @date 2019-03-08
 */
public class CpUtf8 extends Constant {
    private short length;
    private byte[] bytes;
    private String value;

    public CpUtf8(short length, byte[] bytes) {
        this.tag = CONSTANT_UTF8;
        this.length = length;
        this.bytes = bytes;
        this.value = new String(bytes, Charset.forName("utf-8"));
    }

    public short getLength() {
        return length;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UTF8: " + value;
    }
}
