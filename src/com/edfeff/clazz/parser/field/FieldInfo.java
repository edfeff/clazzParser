package com.edfeff.clazz.parser.field;

import com.edfeff.clazz.parser.access.FieldAccessFlag;
import com.edfeff.clazz.parser.attribute.AttributeInfo;
import com.edfeff.clazz.parser.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 字段
 *
 * @author wpp
 * @date 2019-03-08
 */
public class FieldInfo {
    private short accessFlag;
    private short nameIndex;
    private short descriptorIndex;
    private short attributesCount;
    private List<FieldAccessFlag> accessFlags;
    private List<AttributeInfo> attributeInfos;
    private List<Constant> constantPool;

    public FieldInfo(short accessFlag, short nameIndex, short descriptorIndex, short attributesCount, List<Constant> constantPool) {

        this.accessFlags = new ArrayList<>();
        this.attributeInfos = new ArrayList<>();
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
        this.constantPool = constantPool;

        parserAccessFlag();
    }

    public List<AttributeInfo> getAttributeInfos() {
        return attributeInfos;
    }

    public boolean addAttributeInfo(AttributeInfo info) {
        return this.attributeInfos.add(info);
    }

    private void parserAccessFlag() {
        for (FieldAccessFlag flag : FieldAccessFlag.values()) {
            if ((accessFlag & flag.getValue()) == flag.getValue()) {
                this.accessFlags.add(flag);
            }
        }
    }


    public MFiled getFiled() {
        MFiled mFiled = new MFiled();
        mFiled.setName("");

        return mFiled;
    }

    @Override
    public String toString() {
        System.out.println(constantPool.get(this.nameIndex - 1));
        return super.toString();
    }
}
