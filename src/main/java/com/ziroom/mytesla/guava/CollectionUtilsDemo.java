package com.ziroom.mytesla.guava;

import java.util.List;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

/**
 * 一些常用且有用的集合工具类Demo<br>
 * 该demo不改变原有jdk的Collection工具类的使用方式如：<br>
 * Collection.addAll(Collection) <br>
 * Collection.contains(Object)等
 *
 * @author homelink
 *
 */
public class CollectionUtilsDemo {

    public static void main(String[] args) {
	/**
	 * 1 Lists reverse反转 partition分区
	 */
	List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
	List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
	// 把iterable按指定大小分割，得到的子集都不能进行修改操作
	List<List<Integer>> parts = Lists.partition(countUp, 2);// {{1,2}, {3,4}, {5}}

	/**
	 * 2.Iterables
	 */
	List<String> list1 = Lists.newArrayList("a", "b");
	List<String> list2 = Lists.newArrayList("c", "d", "b");
	// 串联多个iterables的懒视图
	Iterable<String> it = Iterables.concat(list1, list2);
	List<String> list3 = Lists.newArrayList(it);
	// 返回对象在iterable中出现的次数
	System.out.println(Iterables.frequency(it, "b"));
	// 返回iterable的第一个元素，若iterable为空则返回默认值
	System.out.println(Iterables.getFirst(list3, null));

	System.out.println(Iterables.getLast(list3, null));

	// 如果两个iterable中的所有元素相等且顺序一致，返回true
	System.out.println(Iterables.elementsEqual(list1, list2));

	// 过滤器功能
	List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
	Iterable<String> result = Iterables.filter(names, Predicates.containsPattern("a"));
	System.out.println(result);// print [Jane, Adam]

	// 查找 找到符合条件的第一个马上返回
	System.out.println(Iterables.find(names, Predicates.containsPattern("a")));// print Jane

    }
}
