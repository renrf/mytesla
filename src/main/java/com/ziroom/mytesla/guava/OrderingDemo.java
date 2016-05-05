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
 * Guava强大的”流畅风格比较器”demo
 *
 * @author homelink
 *
 */
public class OrderingDemo {

    public static void main(String[] args) {
	/**
	 * 常见的静态方法：
	 *
	 * natural()：使用Comparable类型的自然顺序， 例如：整数从小到大，字符串是按字典顺序; <br>
	 * usingToString() ：使用toString()返回的字符串按字典顺序进行排序； <br>
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
	 * 操作方法：
	 *
	 * reverse(): 返回与当前Ordering相反的排序: 　　<br>
	 * nullsFirst(): 返回一个将null放在non-null元素之前的Ordering，其他的和原始的Ordering一样； 　　<br>
	 * nullsLast()：返回一个将null放在non-null元素之后的Ordering，其他的和原始的Ordering一样； 　　<br>
	 * compound(Comparator)：返回一个使用Comparator的Ordering，Comparator作为第二排序元素，例如对bug列表进行排序，先根据bug的级别，再根据优先级进行排序； 　　<br>
	 * lexicographical()：返回一个按照字典元素迭代的Ordering； 　　<br>
	 * onResultOf(Function)：将function应用在各个元素上之后, 在使用原始ordering进行排序； 　　<br>
	 * greatestOf(Iterable iterable, int k)：返回指定的第k个可迭代的最大的元素，按照这个从最大到最小的顺序。是不稳定的。 　　<br>
	 * leastOf(Iterable<E> iterable,int k)：返回指定的第k个可迭代的最小的元素，按照这个从最小到最大的顺序。是不稳定的。 　　<br>
	 * isOrdered(Iterable)：是否有序，Iterable不能少于2个元素。 　　<br>
	 * isStrictlyOrdered(Iterable)：是否严格有序。请注意，Iterable不能少于两个元素。 　　<br>
	 * sortedCopy(Iterable)：返回指定的元素作为一个列表的排序副本。
	 */
	List<Integer> listtest = Ints.asList(1, 9, 2, 4, 5);
	Ordering<Integer> naturalIntReduceOrdering = Ordering.natural();
	System.out.println("listtest:" + listtest);
	System.out.println(naturalIntReduceOrdering.isOrdered(listtest));// true

	/**
	 * 多级排序　<br>
	 * 流程风格比较 超过一定长度的链式调用，也可能会带来阅读和理解上的难度。我们建议按下面的代码这样，在一个链中最多使用三个方法。此外，你也可以把Function分离成中间对象，让链式调用更简洁紧凑。
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
