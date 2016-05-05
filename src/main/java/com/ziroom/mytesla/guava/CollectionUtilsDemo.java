package com.ziroom.mytesla.guava;

import java.util.List;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

/**
 * һЩ���������õļ��Ϲ�����Demo<br>
 * ��demo���ı�ԭ��jdk��Collection�������ʹ�÷�ʽ�磺<br>
 * Collection.addAll(Collection) <br>
 * Collection.contains(Object)��
 *
 * @author homelink
 *
 */
public class CollectionUtilsDemo {

    public static void main(String[] args) {
	/**
	 * 1 Lists reverse��ת partition����
	 */
	List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
	List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
	// ��iterable��ָ����С�ָ�õ����Ӽ������ܽ����޸Ĳ���
	List<List<Integer>> parts = Lists.partition(countUp, 2);// {{1,2}, {3,4}, {5}}

	/**
	 * 2.Iterables
	 */
	List<String> list1 = Lists.newArrayList("a", "b");
	List<String> list2 = Lists.newArrayList("c", "d", "b");
	// �������iterables������ͼ
	Iterable<String> it = Iterables.concat(list1, list2);
	List<String> list3 = Lists.newArrayList(it);
	// ���ض�����iterable�г��ֵĴ���
	System.out.println(Iterables.frequency(it, "b"));
	// ����iterable�ĵ�һ��Ԫ�أ���iterableΪ���򷵻�Ĭ��ֵ
	System.out.println(Iterables.getFirst(list3, null));

	System.out.println(Iterables.getLast(list3, null));

	// �������iterable�е�����Ԫ�������˳��һ�£�����true
	System.out.println(Iterables.elementsEqual(list1, list2));

	// ����������
	List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
	Iterable<String> result = Iterables.filter(names, Predicates.containsPattern("a"));
	System.out.println(result);// print [Jane, Adam]

	// ���� �ҵ����������ĵ�һ�����Ϸ���
	System.out.println(Iterables.find(names, Predicates.containsPattern("a")));// print Jane

    }
}
