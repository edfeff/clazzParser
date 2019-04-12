package com.edfeff.clazz;

import com.edfeff.clazz.parser.Clazz;
import com.edfeff.clazz.parser.ClazzFileParser;
import com.edfeff.clazz.parser.support.ClassDataStream;
import com.edfeff.clazz.parser.support.FileClassDataStream;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ClassDataStream classDataStream = new FileClassDataStream("DiscardClient", "D:\\study\\java\\test\\netty\\001\\netty4\\out\\production\\netty4\\com\\example\\discard\\client\\DiscardClient.class");
        ClazzFileParser clazzFileParser = new ClazzFileParser(classDataStream);
        Clazz clazz = clazzFileParser.getClazz();


    }
}
