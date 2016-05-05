package com.ziroom.mytesla.guava;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个对象比较
 *
 */
public class ObjectsDemo {

    public static void main(String[] args) {
        /**
         * 1 equal方法使用
         * 注意：JDK7引入的Objects类提供了一样的方法Objects.equals
         */
        {
            System.out.println(Objects.equal(null, null));//true
            System.out.println(Objects.equal(null, "str1"));//false
            System.out.println(Objects.equal("str1", null));//false
            System.out.println(Objects.equal("str1", "str1"));//true

            //比较集合
            List<String> l = new ArrayList<String>();
            l.add("1");
            List<String> ll = new ArrayList<String>();
            ll.add("1");
            System.out.println(Objects.equal(l, ll));//true
            ll.add("2");
            System.out.println(Objects.equal(l, ll));//false
        }
    }
}
