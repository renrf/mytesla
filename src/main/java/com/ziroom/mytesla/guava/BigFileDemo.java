package com.ziroom.mytesla.guava;

import com.google.common.io.LineProcessor;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;


/**
 * @author liumy  .
 * @time 2016/5/6　17:19
 * @email　 liumy46@ziroom.com
 */
public class BigFileDemo {


    static class CounterLine implements LineProcessor<Integer> {
        private int rowNum = 0;
        @Override
        public boolean processLine(String line) throws IOException {
            rowNum ++;
            return true;
        }

        @Override
        public Integer getResult() {
            return rowNum;
        }
    }

    public static void main(String[] args) throws IOException {
        String testFilePath = "d:\\test.txt";
        File testFile = new File(testFilePath);
        CounterLine counter = new CounterLine();
        Files.readLines(testFile, Charsets.UTF_16, counter);
        System.out.println(counter.getResult());
    }
}
