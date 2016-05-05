package com.ziroom.mytesla.guava;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * Guavaǿ��ġ��������Ƚ�����demo
 *
 * @author homelink
 *
 */
public class OrderingDemo {

    public static void main(String[] args) {
	/**
	 * �����ľ�̬������
	 *
	 * natural()��ʹ��Comparable���͵���Ȼ˳�� ���磺������С�����ַ����ǰ��ֵ�˳��; <br>
	 * usingToString() ��ʹ��toString()���ص��ַ������ֵ�˳��������� <br>
	 */
	List<String> list = Lists.newArrayList();
	list.add("peida");
	list.add("jerry");
	list.add("harry");
	list.add("eva");
	list.add("jhon");
	list.add("neron");

	System.out.println("list:" + list);
	Ordering<String> naturalOrdering = Ordering.natural();
	Ordering<Object> usingToStringOrdering = Ordering.usingToString();

	System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
	System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));




	/**
	 * ����������
	 *
	 * reverse(): �����뵱ǰOrdering�෴������: ����<br>
	 * nullsFirst(): ����һ����null����non-nullԪ��֮ǰ��Ordering�������ĺ�ԭʼ��Orderingһ���� ����<br>
	 * nullsLast()������һ����null����non-nullԪ��֮���Ordering�������ĺ�ԭʼ��Orderingһ���� ����<br>
	 * compound(Comparator)������һ��ʹ��Comparator��Ordering��Comparator��Ϊ�ڶ�����Ԫ�أ������bug�б���������ȸ���bug�ļ����ٸ������ȼ��������� ����<br>
	 * lexicographical()������һ�������ֵ�Ԫ�ص�����Ordering�� ����<br>
	 * onResultOf(Function)����functionӦ���ڸ���Ԫ����֮��, ��ʹ��ԭʼordering�������� ����<br>
	 * greatestOf(Iterable iterable, int k)������ָ���ĵ�k���ɵ���������Ԫ�أ���������������С��˳���ǲ��ȶ��ġ� ����<br>
	 * leastOf(Iterable<E> iterable,int k)������ָ���ĵ�k���ɵ�������С��Ԫ�أ������������С������˳���ǲ��ȶ��ġ� ����<br>
	 * isOrdered(Iterable)���Ƿ�����Iterable��������2��Ԫ�ء� ����<br>
	 * isStrictlyOrdered(Iterable)���Ƿ��ϸ�������ע�⣬Iterable������������Ԫ�ء� ����<br>
	 * sortedCopy(Iterable)������ָ����Ԫ����Ϊһ���б�����򸱱���
	 */
	List<Integer> listtest = Ints.asList(1, 9, 2, 4, 5);
	Ordering<Integer> naturalIntReduceOrdering = Ordering.natural();
	System.out.println("listtest:" + listtest);
	System.out.println(naturalIntReduceOrdering.isOrdered(listtest));// true

	/**
	 * �༶����<br>
	 * ���̷��Ƚ� ����һ�����ȵ���ʽ���ã�Ҳ���ܻ�����Ķ�������ϵ��Ѷȡ����ǽ��鰴����Ĵ�����������һ���������ʹ���������������⣬��Ҳ���԰�Function������м��������ʽ���ø������ա�
	 */

	List<Foo> fooList = Lists.newArrayList();
	fooList.add(new Foo(2, "b"));
	fooList.add(new Foo(1, "f"));
	fooList.add(new Foo(1, "c"));
	System.out.println("fooList:" + fooList);
	Collections.sort(fooList, new Comparator<Foo>() {
	    @Override
	    public int compare(Foo f1, Foo f2) {
		return ComparisonChain.start()// <br>
			.compare(f1.notSortedBy, f2.notSortedBy)// <br>
			.compare(f1.secondSortedBy, f2.secondSortedBy)// <br>
			.result();
	    }
	});
	System.out.println("fooList:" + fooList);
    }

    static class Foo {
	Integer notSortedBy;
	String secondSortedBy;

	public Foo(Integer f, String a) {
	    notSortedBy = f;
	    secondSortedBy = a;
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("Foo [notSortedBy=");
	    builder.append(notSortedBy);
	    builder.append(", secondSortedBy=");
	    builder.append(secondSortedBy);
	    builder.append("]");
	    return builder.toString();
	}

    }
}
