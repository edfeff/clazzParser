package com.edfeff.clazz.parser.util;

import java.io.*;

/**
 * 获取数据流
 *
 * @author wpp
 */
public class FileUtils {
    public static FileInputStream getFileInputStream(String file) {
        if (file == null || "".equals(file)) return null;
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
        }
        return null;
    }

    public static DataInputStream getDataFileInputStream(String file) {
        FileInputStream fileInputStream = getFileInputStream(file);
        if (fileInputStream == null) return null;
        return new DataInputStream(fileInputStream);
    }

    public static DataInputStream getDataFileInputStream(InputStream inputStream) {
        return new DataInputStream(inputStream);
    }

    public static DataInputStream getDataFileInputStream(File file) {
        if (file == null) return null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            return getDataFileInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
        }
        return null;
    }
}