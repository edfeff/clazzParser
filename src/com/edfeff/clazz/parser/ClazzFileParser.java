package com.edfeff.clazz.parser;

import com.edfeff.clazz.parser.access.ClazzAccessFlag;
import com.edfeff.clazz.parser.attribute.AttributeInfo;
import com.edfeff.clazz.parser.constant.*;
import com.edfeff.clazz.parser.field.FieldInfo;
import com.edfeff.clazz.parser.method.MethodInfo;
import com.edfeff.clazz.parser.support.ClassDataStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析class文件，作为演示解析，不产生真正的class类
 *
 * @author wpp
 * @date 2019-03-07
 */
public class ClazzFileParser {

    ClassDataStream classDataStream = null;
    //class文件名
    private String fileName = null;
    //class文件流
    private DataInputStream data = null;
    //魔数
    private int magic;
    //小版本号
    private short minorVersion;
    //主版本号
    private short majorVersion;
    //此class索引
    private short thisClazzIndex;
    //超类class索引
    private short superClazz;
    //接口数量
    private short interfaceCount;
    //字段数量
    private short fieldCount;
    //方法数量
    private short methodCount;
    //属性数量
    private short attributeCount;
    //常量池中常量的个数
    private short constantPoolCount;
    //常量池
    private List<Constant> constantPool;
    //此类访问标识
    private List<ClazzAccessFlag> accessFlags;
    //此类的接口
    private List<Short> interfaces;
    //此类的字段
    private List<FieldInfo> fieldInfos;
    //此类的方法
    private List<MethodInfo> methodInfos;
    //此类的属性
    private List<AttributeInfo> attributeInfos;

    public ClazzFileParser(ClassDataStream classDataStream) throws IOException {
        this.classDataStream = classDataStream;
        this.fileName = classDataStream.getName();
        this.data = classDataStream.getDataInputStream();
        init();
        parser();
    }

    private void init() {
        constantPool = new ArrayList<>();
        accessFlags = new ArrayList<>();
        interfaces = new ArrayList<>();
        fieldInfos = new ArrayList<>();
        methodInfos = new ArrayList<>();
        attributeInfos = new ArrayList<>();
    }

    /**
     * 组成一个Clazz对象
     *
     * @return
     */
    public Clazz getClazz() {
//        TODO
//        accessFlags.stream().forEach(System.out::println);
//        interfaces.stream().forEach(System.out::println);
        fieldInfos.stream().forEach(System.out::println);

        return null;
    }

    /**
     * 解析总流程： 顺序不可变动！
     * <p>
     * 魔数-版本-常量池-访问标识-本类-超类-接口-字段-方法-属性
     *
     * @throws IOException
     */
    private void parser() throws IOException {
        parserMagic();
        parserVersion();
        parserConstantPool();
        parserAccessFlag();
        parserThisClazz();
        parserSuperClazz();
        parserInterface();
        parserField();
        parserMethods();
        parserAttribute();
    }

    /**
     * 解析属性
     *
     * @throws IOException
     */
    private void parserAttribute() throws IOException {
        attributeCount = data.readShort();
        if (attributeCount > 0) {
            for (int j = 0; j < attributeCount; j++) {
                short attributeNameIndex = data.readShort();
                int attributeLength = data.readInt();
                byte[] info = new byte[attributeLength];
                data.read(info);
                attributeInfos.add(new AttributeInfo(attributeNameIndex, attributeLength, info));
            }
        }
    }

    /**
     * 解析方法
     *
     * @throws IOException
     */
    private void parserMethods() throws IOException {
        methodCount = data.readShort();
        for (int i = 0; i < methodCount; i++) {
            short accessFlag = data.readShort();
            short nameIndex = data.readShort();
            short descriptorIndex = data.readShort();
            short attributeCount = data.readShort();
            MethodInfo methodInfo = new MethodInfo(accessFlag, nameIndex, descriptorIndex, attributeCount);
            if (attributeCount > 0) {
                for (int j = 0; j < attributeCount; j++) {
                    short attributeNameIndex = data.readShort();
                    int attributeLength = data.readInt();
                    byte[] info = new byte[attributeLength];
                    data.read(info);
                    methodInfo.addAttributeInfo(new AttributeInfo(attributeNameIndex, attributeLength, info));
                }
            }
            methodInfos.add(methodInfo);
        }
    }

    /**
     * 解析字段
     * <p>
     * 可以使用委托模式重构，这样结构更加清晰了
     * <p>
     * 目前先使用顺序解析的方法
     *
     * @throws IOException
     */
    private void parserField() throws IOException {
        //TODO 可使用委托模式重构
        fieldCount = data.readShort();
        for (int i = 0; i < fieldCount; i++) {
            short accessFlag = data.readShort();
            short nameIndex = data.readShort();
            short descriptorIndex = data.readShort();
            short attributesCount = data.readShort();
            FieldInfo fieldInfo = new FieldInfo(accessFlag, nameIndex, descriptorIndex, attributesCount, constantPool);
            if (attributesCount > 0) {
                for (int j = 0; j < attributesCount; j++) {
                    short attributeNameIndex = data.readShort();
                    int attributeLength = data.readInt();
                    byte[] info = new byte[attributeLength];
                    data.read(info);
                    fieldInfo.addAttributeInfo(new AttributeInfo(attributeNameIndex, attributeLength, info));
                }
            }
            fieldInfos.add(fieldInfo);
        }
    }

    /**
     * 解析接口
     *
     * @throws IOException
     */
    private void parserInterface() throws IOException {
        interfaceCount = data.readShort();
        if (interfaceCount > 0) {
            for (int i = 0; i < interfaceCount; i++) {
                interfaces.add(data.readShort());
            }
        }
    }

    /**
     * 解析超类索引
     *
     * @throws IOException
     */
    private void parserSuperClazz() throws IOException {
        superClazz = data.readShort();
    }

    /**
     * 解析本类索引
     *
     * @throws IOException
     */
    private void parserThisClazz() throws IOException {
        thisClazzIndex = data.readShort();
    }

    /**
     * 解析此类访问标识
     *
     * @throws IOException
     */
    private void parserAccessFlag() throws IOException {
        short accessFlags = data.readShort();
        for (ClazzAccessFlag flag : ClazzAccessFlag.values()) {
            if ((accessFlags & flag.getValue()) == flag.getValue()) {
                this.accessFlags.add(flag);
            }
        }
    }

    /**
     * 解析常量池
     */
    private void parserConstantPool() throws IOException {
        //constant_pool_count
        constantPoolCount = data.readShort();
        //iterator the constantPool
        for (int i = 0; i < constantPoolCount - 1; i++) {
            byte fag = data.readByte();
            switch (fag) {
                case Constant.CONSTANT_CLASS:
                    constantPool.add(new CpClass(data.readShort()));
                    break;
                case Constant.CONSTANT_FIELDREF:
                    constantPool.add(new CpFieldref(data.readShort(), data.readShort()));
                    break;
                case Constant.CONSTANT_METHODREF:
                    constantPool.add(new CpMethodref(data.readShort(), data.readShort()));
                    break;
                case Constant.CONSTANT_INTERFACEMETHODREF:
                    constantPool.add(new CpInterfaceMethodref(data.readShort(), data.readShort()));
                    break;
                case Constant.CONSTANT_STRING:
                    constantPool.add(new CpString(data.readShort()));
                    break;
                case Constant.CONSTANT_INTEGER:
                    constantPool.add(new CpInteger(data.readInt()));
                    break;
                case Constant.CONSTANT_FLOAT:
                    constantPool.add(new CpFloat(data.readFloat()));
                    break;
                case Constant.CONSTANT_LONG:
                    constantPool.add(new CpLong(data.readLong()));
                    break;
                case Constant.CONSTANT_DOUBLE:
                    constantPool.add(new CpDouble(data.readDouble()));
                    break;
                case Constant.CONSTANT_NAMEANDTYPE:
                    constantPool.add(new CpNameAndType(data.readShort(), data.readShort()));
                    break;
                case Constant.CONSTANT_UTF8: {
                    short length = data.readShort();
                    byte[] bytes = new byte[length];
                    data.read(bytes);
                    constantPool.add(new CpUtf8(length, bytes));
                    break;
                }
                case Constant.CONSTANT_METHODHANDLE:
                    constantPool.add(new CpMethodHandle(data.readByte(), data.readShort()));
                    break;
                case Constant.CONSTANT_METHODTYPE:
                    constantPool.add(new CpMethodType(data.readShort()));
                    break;
                case Constant.CONSTANT_INVOKEDYNAMIC:
                    constantPool.add(new CpInvokeDynamic(data.readShort(), data.readShort()));
                    break;
            }
        }
    }

    /**
     * 解析版本
     *
     * @throws IOException
     */
    private void parserVersion() throws IOException {
        //version
        minorVersion = data.readShort();
        majorVersion = data.readShort();
    }

    /**
     * 解析魔数
     *
     * @throws IOException
     */
    private void parserMagic() throws IOException {
        //magic
        magic = data.readInt();
    }
}
