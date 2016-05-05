package com.ziroom.mytesla.guava;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������Ƚ�
 *
 */
public class ObjectsDemo {

    public static void main(String[] args) {
        /**
         * 1 equal����ʹ��
         * ע�⣺JDK7�����Objects���ṩ��һ���ķ���Objects.equals
         */
        {
            System.out.println(Objects.equal(null, null));//true
            System.out.println(Objects.equal(null, "str1"));//false
            System.out.println(Objects.equal("str1", null));//false
            System.out.println(Objects.equal("str1", "str1"));//true

            //�Ƚϼ���
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
