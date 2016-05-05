package com.ziroom.mytesla.guava;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����ת�ַ���
 * Joiner��Ҫ��Խ�Collection��Map�ļ���ת�ַ����ĳ���
 */
public class JoinerDemo {
    private static final String DELIMITER = ",";
    //Joinerһ���������ɱ䣬���ϲ����ԣ�����̰߳�ȫ
    private static final Joiner joiner = Joiner.on(DELIMITER);

    public static void main(String[] args) {
        /**
         * 1 appendTo����ʹ��
         * ��һ��������ʵ����Appendable�ӿڵ���
         * ����Ĳ���������ʵ���˼��ϡ����顢�ɱ䳤����
         *
         * ע��NULL�Ĵ���
         * ���ϡ����顢�ɱ䳤�����к���NULL,����������׳���ָ���쳣,���������һ�����ַ�ʽ��
         * 1 ʹ��skipNulls�Զ�����NULLֵ
         * 2 ʹ��useForNull�滻NULL
         */
        {
            //1.1 ����
            StringBuilder sb = new StringBuilder("result:");
            List<String> list = new ArrayList<String>();
            list.add("one");
            list.add("two");
            list.add("three");
            joiner.appendTo(sb, list);
            System.out.println(sb);

            //1.2 ����
            sb = new StringBuilder("result:");
            String[] arr = new String[]{"one", "two", "three"};
            joiner.appendTo(sb, arr);
            System.out.println(sb);

            //1.3 �ɱ䳤����
            sb = new StringBuilder("result:");
            joiner.appendTo(sb, "one", "two", "three");
            System.out.println(sb);

            // 1.4 skipNulls
            list.add(null);
            list.add("fore");
            joiner.skipNulls().appendTo(sb, list);
            System.out.println(sb);

            // 1.5 useForNull
            list.add(null);
            list.add("fore");
            joiner.useForNull("empty").appendTo(sb, list);
            System.out.println(sb);

        }
        /**
         * 2 join����ʹ��
         * ��һ������������ʵ���˼��ϡ����顢�ɱ䳤����
         * ע��NULL�Ĵ���ͬ��
         */
        {
            //2.1 ����
            List<String> list = new ArrayList<String>();
            list.add("one");
            list.add("two");
            list.add("three");
            System.out.println(joiner.join(list));

            //2.2 ����
            String[] arr = new String[]{"one", "two", "three"};
            System.out.println(joiner.join(arr));

            //2.3 �ɱ䳤����
            System.out.println(joiner.join("one", "two", "three"));
        }


        /**
         * 3 Mapת�ַ���
         * ��һ������������ʵ���˼��ϡ����顢�ɱ䳤����
         * ע��NULL�Ĵ���
         * 1 �޷�ʹ��skipNulls�Զ�����NULLֵ,��ʹ�û��ǻ��ָ���쳣
         * 2 ʹ��useForNull�滻NULL
         */
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
            map.put("key4", null);//useForNull("empty") ���key4=empty
            Joiner.MapJoiner mapJoiner = joiner.withKeyValueSeparator("=");
            System.out.println(mapJoiner.join(map));
        }
    }
}
