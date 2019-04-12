package com.edfeff.clazz.parser.support;

import com.edfeff.clazz.parser.util.FileUtils;

import java.io.DataInputStream;

public class FileClassDataStream implements ClassDataStream {
    private String name;
    private DataInputStream dataInputStream;

    public FileClassDataStream(String name, String file) {
        this.name = name;
        this.dataInputStream = FileUtils.getDataFileInputStream(file);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }
}
