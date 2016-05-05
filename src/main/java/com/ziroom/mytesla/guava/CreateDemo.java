package com.ziroom.mytesla.guava;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;

/**
 * ���ϴ���demo<br>
 * ���Ϸ�Ϊ���ɱ伯�ϺͿɱ伯��<br>
 * <p>
 * ע�⣺ʵ��ʹ���о����������ɱ伯��<br>
 * <b>���ɱ�����кܶ��ŵ㣬������<b><br>
 * <p/>
 * 1 �����󱻲����ŵĿ����ʱ�����ɱ���ʽ�ǰ�ȫ�ģ�<br>
 * 2 ���ɱ���󱻶���̵߳���ʱ�������ھ�̬�������� ��<br>
 * 3 ���ɱ伯�ϲ���Ҫ���Ǳ仯����˿��Խ�ʡʱ��Ϳռ䡣���в��ɱ�ļ��϶������ǵĿɱ���ʽ�и��õ��ڴ������ʣ������Ͳ���ϸ�ڣ��� <br>
 * 4 ���ɱ������Ϊ�й̶����䣬������Ϊ��������ȫʹ�á� <br>
 * <p/>
 * ע�⣺��������Ĳ��ɱ俽����һ��ܺõķ����Ա�̼��ɡ�<br>
 * GuavaΪ����JDK��׼�������ͺ�Guava�¼������Ͷ��ṩ�˼����õĲ��ɱ�汾�� <br>
 * <p/>
 * JDKҲ�ṩ��Collections.unmodifiableXXX�����Ѽ��ϰ�װΪ���ɱ���ʽ����������Ϊ�����ã�<br>
 * 1 ���ض�����׸���������ʵ������������������Կ����ĳ�����<br>
 * 2 ����ȫ��Ҫ��֤û��ͨ��ԭ���ϵ����ý����޸ģ����صļ��ϲ�����ʵ�ϲ��ɱ�ģ�<br>
 * 3 ��Ч����װ���ļ�����Ȼ���пɱ伯�ϵĿ��������粢���޸ĵļ�顢ɢ�б�Ķ���ռ䣬�ȵȡ�<br>
 * <p/>
 * �����û���޸�ĳ�����ϵ����󣬻���ϣ��ĳ�����ϱ��ֲ���ʱ�����������Եؿ��������ɱ伯���Ǹ��ܺõ�ʵ����
 * <p/>
 * ��Ҫ��ʾ������Guava���ɱ伯�ϵ�ʵ�ֶ�������nullֵ��<br>
 * ���Ƕ�Google�ڲ��Ĵ����������ϸ�о�������ֻ��5%�������Ҫ�ڼ���������nullԪ�أ�ʣ�µ�95%������������nullֵ�Ϳ���ʧ�ܡ�<br>
 * �������Ҫ�ڲ��ɱ伯����ʹ��null����ʹ��JDK�е�Collections.unmodifiableXXX����������ϸ�ڽ�����ο���ʹ�úͱ���null����
 * </p>
 *
 * @author homelink
 */
public class CreateDemo {

    public static void main(String[] args) {
        /**
         * 1 �������ɱ伯��,��set��ʾ,����list��map���� <br>
         * ���ò��ɱ伯�ϰ����� <br>
         * ImmutableList ImmutableSet ImmutableSortedSet ImmutableMap ImmutableSortedMap
         */
        // 1.1 ImmutableXXX.copyOf
        Set<String> sets = new HashSet<String>();
        sets.add("a");
        Set<String> copySets = ImmutableSet.copyOf(sets);
        System.out.println(sets);
       // copySets.add("1");
        System.out.println(copySets);

        String[] arr = {"a", "d", "b"};
        Set<String> copyArr = ImmutableSet.copyOf(arr);
        System.out.println("arr=" + arr);
        System.out.println(copyArr);

        // 1.2 ImmutableXXX.of
        Set<String> sets2 = ImmutableSet.of();
        Set<String> sets3 = ImmutableSet.of("a");
        Set<String> sets4 = ImmutableSet.of("a", "d", "b");
        System.out.println(sets2);
        System.out.println(sets3);
        System.out.println(sets4);
        // ������ʹ�����򲻿ɱ伯�ϣ��������ڹ��켯�ϵ�ʱ����ɵģ��磺
        Set<String> sets5 = ImmutableSortedSet.of("c", "a", "d", "b");
        System.out.println(sets5);// ����ӡ[a, b, c, d]

        /**
         * 2 �����ɱ伯��,��list��ʾ,����set��map���� <br>
         * ���ÿɱ伯�ϰ����� <br>
         * Sets Maps Lists
         */
        // 2.1 newArrayList
        List<String> lists = Lists.newArrayList();
        List<String> lists2 = Lists.newArrayList("c", "a", "d", "b");
        System.out.println(lists2);
        List<String> lists3 = Lists.newArrayListWithCapacity(10);
        lists3.add("a");
        lists3.add("b");
        lists3.add("c");
        System.out.println("lists3="+lists3);
        // 2.2 newCopyOnWriteArrayList
        CopyOnWriteArrayList<String> coal = Lists.newCopyOnWriteArrayList();
        CopyOnWriteArrayList<String> coal1 = Lists.newCopyOnWriteArrayList(lists);
        // 2.3 newLinkedList
        LinkedList<String> linkedList = Lists.newLinkedList();
        LinkedList<String> linkedList2 = Lists.newLinkedList(lists3);
    }
}
