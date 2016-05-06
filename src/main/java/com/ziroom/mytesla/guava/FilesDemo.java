package com.ziroom.mytesla.guava;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.lang.System.err;

/**
 * @author liumy  .
 * @time 2016/5/6　17:07
 * @email　 liumy46@ziroom.com
 */
public class FilesDemo {


    /**
     * 演示向文件中写入字节流
     *
     * @param fileName 要写入文件的文件名
     * @param contents 要写入的文件内容
     */
    public static void demoFileWrite(final String fileName, final String contents) {
        final File newFile = new File(fileName);
        try {
            Files.write(contents.getBytes(), newFile);
        } catch (IOException fileIoEx) {
            err.println("ERROR trying to write to file '" + fileName + "' - "
                    + fileIoEx.toString());
        }
    }

    /**
     * 读取字符串
     * @return
     * @throws Exception
     */
    public static List<String> readLine()throws  Exception {
        String testFilePath = "d:\\test.txt";
        File testFile = new File(testFilePath);
        List<String> lines = Files.readLines(testFile, Charsets.UTF_8);
        return lines;
    }





    public  static  void main(String[] args){




    }

}
