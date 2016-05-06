package com.ziroom.mytesla.guava;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * Splitter功能与Joiner相反，其对字符串进行分割操作
 */
public class SplitterDemo {
    private static final String DELIMITER = ",";
    //Joiner一旦创建不可变，符合不变性，因此线程安全
    private static final Splitter splitter = Splitter.on(DELIMITER);

    private static String numberList = "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten";


    public static void main(String[] args) {
        {
            //1.1 返回Iterable<String>对象,其实是com.google.common.base.Splitter的一个内部类实例
            String s = "one,two,three";
            Iterable<String> iterable = splitter.split(s);
            System.out.println(iterable.getClass().getName());
            System.out.println(iterable);

            //1.2 List<String>对象,其实是java.util.Collections$UnmodifiableRandomAccessList实例,只读List
            List<String> list = splitter.splitToList(s);
            System.out.println(list.getClass().getName());
            System.out.println(list);
            //list.add("four");//list只读,此处将抛出java.lang.UnsupportedOperationException

            //1.3 空格处理
            s = "one ,two ,three ";
            System.out.println(splitter.trimResults().splitToList(s));
        }


        {
            //2.1 返回Iterable<String>对象,其实是java.util.Collections$UnmodifiableMap实例
            String s = "key3=value3,key2=value2,key1=value1 ";
            Splitter.MapSplitter mapSplitter = splitter.trimResults().withKeyValueSeparator("=");
            Map<String, String> map = mapSplitter.split(s);
            System.out.println(map.getClass().getName());
            System.out.println(map);
//            map.put("key4","value4");//map只读,此处将抛出java.lang.UnsupportedOperationException

            //2.2 空格处理 splitter.trimResults().withKeyValueSeparator("=");
            s = "key3=value3,key2=value2,key1=value1 ";//能处理字符串前后空格和,号前后空格,==号前后空格不能处理

        }



        long start = 0;
       /* for(int i=0; i<1000000; i++) {
            StringUtils.split(numberList, ',');
        }*/

        start = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            Splitter.on(',').split(numberList);
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        Splitter splitter = Splitter.on(',');
        for(int i=0; i<1000000; i++) {
            splitter.split(numberList );
        }
        System.out.println(System.currentTimeMillis() - start);




    }
}
