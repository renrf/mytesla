package com.ziroom.mytesla.guava;

import com.google.common.base.CharMatcher;
import com.google.common.collect.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 简单常用的 java 字符串匹配操作
 * <p/>
 * 注意：负责的正则表达式匹配请使用jdk原生类
 */
public class CharMatcherDemo {

    public static void main(String[] args) {

        /**
         * 1 提取匹配的子串
         */
        {
            // 提取字母 return SOMEtextandmore
            System.out.println(CharMatcher.JAVA_LETTER.retainFrom("SOME text 899083 and more"));
            // 提取数字 return 899083
            System.out.println(CharMatcher.JAVA_DIGIT.retainFrom("some text 899083 and more"));
            // 提取小写字母 return textandmore
            System.out.println(CharMatcher.JAVA_LOWER_CASE.retainFrom("SOME text 899083 and more"));
            // 提取大写字母 return textandmore
            System.out.println(CharMatcher.JAVA_UPPER_CASE.retainFrom("SOME text 899083 and more"));
            // 提取非中文
            System.out.println(CharMatcher.SINGLE_WIDTH.retainFrom("SOMEの我是中文9897 more"));
            // 提取控制字符
            System.out.println(CharMatcher.JAVA_ISO_CONTROL.retainFrom("SOME\t\r\b text 899083 and more"));

            Multiset<String> multiset = HashMultiset.create();
            multiset.add("1");
            multiset.add("1");
            System.out.println(multiset.size() + "--------------------------------------------");


            Set<String> set = new HashSet<String>();
            set.add("1");
            set.add("1");
            System.out.println(set.size() + "--------------------------------------------");
            /**
             * 2 替换匹配的子串
             *
             */
            {
                System.out.println(CharMatcher.JAVA_ISO_CONTROL.replaceFrom("SOME\t\r\b text 899083 and more", "*")+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                // /cofiguration/appInterface!getDataTypeCount.action 转换为 cofiguration_appInterface_getDataTypeCount
                String s = "/cofiguration/appInterface!getDataTypeCount.action";
                s = CharMatcher.JAVA_LETTER_OR_DIGIT.negate().replaceFrom(s, "_");
                if (s.startsWith("_")) {
                    s = s.substring(1);
                }
                if (s.endsWith("_action")) {
                    s = s.substring(0, s.length() - 7);
                }
                System.out.println(s);

            }

            /**
             * 3 删除匹配的子串
             */
            {
                // 删除匹配到的字符
                System.out.println(CharMatcher.JAVA_LETTER.removeFrom("SOME text 899083 and more"));
                // 删除首尾匹配到的字符并返回
                System.out.println(CharMatcher.JAVA_LETTER.trimFrom("SOME text 899083 and more"));
                // 删除首部匹配到的字符并返回
                System.out.println(CharMatcher.JAVA_LETTER.trimLeadingFrom("SOME text 899083 and more"));
                // 删除尾部匹配到的字符并返回
                System.out.println(CharMatcher.JAVA_LETTER.trimTrailingFrom("SOME text 899083 and more"));
            }

            /**
             * 4 返回匹配的个数
             */
            {
                // 个数：返回数字的个数
                System.out.println(CharMatcher.JAVA_DIGIT.countIn("SOME text 899083 and more"));

                Multimap multimap = HashMultimap.create();

                Multimap multiMapList = ArrayListMultimap.create();

                multiMapList.put("key", "111");


            }

            /**
             * 5 返回匹配的位置
             */
            {

                StringBuilder stringBuilder = new StringBuilder();

                StringBuffer sb = new StringBuffer();
                sb.append("11");
                System.out.println(sb.toString());
                // 位置：返回sequence中匹配到的第一个字符的坐标
                System.out.println(CharMatcher.JAVA_DIGIT.indexIn("SOME text 899083 and more"));
                // 位置：返回从start开始,在sequence中匹配到的第一个字符的坐标
                System.out.println(CharMatcher.JAVA_DIGIT.indexIn("SOME text 899083 and more", 11));
                // 位置：返回sequence中最后一次匹配到的字符的坐标
                System.out.println(CharMatcher.JAVA_DIGIT.lastIndexIn("SOME text 899083 and more"));
            }

            /**
             * 6 返回匹配的结果true or false
             */
            {
                // 是否匹配：只要sequence中有任意字符能匹配Matcher,返回true
                System.out.println(CharMatcher.JAVA_DIGIT.matchesAnyOf("SOME text 899083 and more"));
                // 是否匹配：sequence中所有字符都能匹配Matcher,返回true
                System.out.println("&&&&&&&" + CharMatcher.JAVA_LETTER_OR_DIGIT.matchesAllOf("SOME text 899083 and more"));
                // 是否匹配：sequence中所有字符都不能匹配Matcher,返回true
                System.out.println(CharMatcher.JAVA_DIGIT.matchesNoneOf("SOME text 899083 and more"));
            }

        }
    }
}
