package com.ziroom.mytesla.guava;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * Splitter������Joiner�෴������ַ������зָ����
 */
public class SplitterDemo {
    private static final String DELIMITER = ",";
    //Joinerһ���������ɱ䣬���ϲ����ԣ�����̰߳�ȫ
    private static final Splitter splitter = Splitter.on(DELIMITER);

    private static String numberList = "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten";


    public static void main(String[] args) {
        {
            //1.1 ����Iterable<String>����,��ʵ��com.google.common.base.Splitter��һ���ڲ���ʵ��
            String s = "one,two,three";
            Iterable<String> iterable = splitter.split(s);
            System.out.println(iterable.getClass().getName());
            System.out.println(iterable);

            //1.2 List<String>����,��ʵ��java.util.Collections$UnmodifiableRandomAccessListʵ��,ֻ��List
            List<String> list = splitter.splitToList(s);
            System.out.println(list.getClass().getName());
            System.out.println(list);
            //list.add("four");//listֻ��,�˴����׳�java.lang.UnsupportedOperationException

            //1.3 �ո���
            s = "one ,two ,three ";
            System.out.println(splitter.trimResults().splitToList(s));
        }


        {
            //2.1 ����Iterable<String>����,��ʵ��java.util.Collections$UnmodifiableMapʵ��
            String s = "key3=value3,key2=value2,key1=value1 ";
            Splitter.MapSplitter mapSplitter = splitter.trimResults().withKeyValueSeparator("=");
            Map<String, String> map = mapSplitter.split(s);
            System.out.println(map.getClass().getName());
            System.out.println(map);
//            map.put("key4","value4");//mapֻ��,�˴����׳�java.lang.UnsupportedOperationException

            //2.2 �ո��� splitter.trimResults().withKeyValueSeparator("=");
            s = "key3=value3,key2=value2,key1=value1 ";//�ܴ����ַ���ǰ��ո��,��ǰ��ո�,==��ǰ��ո��ܴ���

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
