package com.edfeff.clazz.parser.method;

import com.edfeff.clazz.parser.access.MethodAccessFlag;
import com.edfeff.clazz.parser.attribute.AttributeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法
 *
 * @author wpp
 * @date 2019-03-08
 */
public class MethodInfo {
    short accessFlag;
    short nameIndex;
    short descriptorIndex;
    short attributesCount;
    private List<MethodAccessFlag> accessFlags;
    List<AttributeInfo> attributeInfos;

    public MethodInfo(short accessFlag, short nameIndex, short descriptorIndex, short attributesCount) {
        this.attributeInfos = new ArrayList<>();
        this.accessFlags = new ArrayList<>();
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
        parserAccessFlag();

    }

    private void parserAccessFlag() {
        for (MethodAccessFlag flag : MethodAccessFlag.values()) {
            if ((accessFlag & flag.getValue()) == flag.getValue()) {
                this.accessFlags.add(flag);
            }
        }
    }

    public List<AttributeInfo> getAttributeInfos() {
        return attributeInfos;
    }

    public boolean addAttributeInfo(AttributeInfo info) {
        return this.attributeInfos.add(info);
    }

}
