package com.ziroom.mytesla.guava;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合转字符串
 * Joiner主要针对将Collection和Map的集合转字符串的场景
 */
public class JoinerDemo {
    private static final String DELIMITER = ",";
    //Joiner一旦创建不可变，符合不变性，因此线程安全
    private static final Joiner joiner = Joiner.on(DELIMITER);

    public static void main(String[] args) {
        /**
         * 1 appendTo方法使用
         * 第一个参数是实现了Appendable接口的类
         * 后面的参数可以是实现了集合、数组、可变长参数
         *
         * 注意NULL的处理：
         * 集合、数组、可变长参数中含有NULL,不做处理会抛出空指针异常,如果处理有一下两种方式：
         * 1 使用skipNulls自动忽略NULL值
         * 2 使用useForNull替换NULL
         */
        {
            //1.1 集合
            StringBuilder sb = new StringBuilder("result:");
            List<String> list = new ArrayList<String>();
            list.add("one");
            list.add("two");
            list.add("three");
            joiner.appendTo(sb, list);
            System.out.println(sb);

            //1.2 数组
            sb = new StringBuilder("result:");
            String[] arr = new String[]{"one", "two", "three"};
            joiner.appendTo(sb, arr);
            System.out.println(sb);

            //1.3 可变长参数
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
         * 2 join方法使用
         * 第一个参数可以是实现了集合、数组、可变长参数
         * 注意NULL的处理：同上
         */
        {
            //2.1 集合
            List<String> list = new ArrayList<String>();
            list.add("one");
            list.add("two");
            list.add("three");
            System.out.println(joiner.join(list));

            //2.2 数组
            String[] arr = new String[]{"one", "two", "three"};
            System.out.println(joiner.join(arr));

            //2.3 可变长参数
            System.out.println(joiner.join("one", "two", "three"));
        }


        /**
         * 3 Map转字符串
         * 第一个参数可以是实现了集合、数组、可变长参数
         * 注意NULL的处理：
         * 1 无法使用skipNulls自动忽略NULL值,即使用还是会空指针异常
         * 2 使用useForNull替换NULL
         */
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
            map.put("key4", null);//useForNull("empty") 输出key4=empty
            Joiner.MapJoiner mapJoiner = joiner.withKeyValueSeparator("=");
            System.out.println(mapJoiner.join(map));
        }
    }
}
