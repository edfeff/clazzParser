package com.example.clazz.parser.field;

import com.example.clazz.parser.access.FieldAccessFlag;
import com.example.clazz.parser.attribute.AttributeInfo;

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

    public FieldInfo(short accessFlag, short nameIndex, short descriptorIndex, short attributesCount) {
        this.accessFlags = new ArrayList<>();
        this.attributeInfos = new ArrayList<>();
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
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

}
