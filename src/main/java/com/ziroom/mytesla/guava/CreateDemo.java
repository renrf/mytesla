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
 * 集合创建demo<br>
 * 集合分为不可变集合和可变集合<br>
 * <p>
 * 注意：实际使用中尽量创建不可变集合<br>
 * <b>不可变对象有很多优点，包括：<b><br>
 * <p/>
 * 1 当对象被不可信的库调用时，不可变形式是安全的；<br>
 * 2 不可变对象被多个线程调用时，不存在竞态条件问题 ；<br>
 * 3 不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）； <br>
 * 4 不可变对象因为有固定不变，可以作为常量来安全使用。 <br>
 * <p/>
 * 注意：创建对象的不可变拷贝是一项很好的防御性编程技巧。<br>
 * Guava为所有JDK标准集合类型和Guava新集合类型都提供了简单易用的不可变版本。 <br>
 * <p/>
 * JDK也提供了Collections.unmodifiableXXX方法把集合包装为不可变形式，但我们认为不够好：<br>
 * 1 笨重而且累赘：不能舒适地用在所有想做防御性拷贝的场景；<br>
 * 2 不安全：要保证没人通过原集合的引用进行修改，返回的集合才是事实上不可变的；<br>
 * 3 低效：包装过的集合仍然保有可变集合的开销，比如并发修改的检查、散列表的额外空间，等等。<br>
 * <p/>
 * 如果你没有修改某个集合的需求，或者希望某个集合保持不变时，把它防御性地拷贝到不可变集合是个很好的实践。
 * <p/>
 * 重要提示：所有Guava不可变集合的实现都不接受null值。<br>
 * 我们对Google内部的代码库做过详细研究，发现只有5%的情况需要在集合中允许null元素，剩下的95%场景都是遇到null值就快速失败。<br>
 * 如果你需要在不可变集合中使用null，请使用JDK中的Collections.unmodifiableXXX方法。更多细节建议请参考“使用和避免null”。
 * </p>
 *
 * @author homelink
 */
public class CreateDemo {

    public static void main(String[] args) {
        /**
         * 1 创建不可变集合,用set演示,其他list和map类似 <br>
         * 常用不可变集合包括： <br>
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
        // 还可以使用有序不可变集合，排序是在构造集合的时候完成的，如：
        Set<String> sets5 = ImmutableSortedSet.of("c", "a", "d", "b");
        System.out.println(sets5);// 将打印[a, b, c, d]

        /**
         * 2 创建可变集合,用list演示,其他set和map类似 <br>
         * 常用可变集合包括： <br>
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
