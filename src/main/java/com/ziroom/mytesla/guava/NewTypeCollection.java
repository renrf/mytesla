package com.ziroom.mytesla.guava;

import com.google.common.base.CharMatcher;

/**
 * Guava引入了很多JDK没有的、但我们发现明显有用的新集合类型,包括：<br>
 * multisets, multimaps, tables, bidirectional maps等<br>
 *
 * 这些类的使用场景相对来说不是很多，因此此处不具体演示，实际使用之前可参考一下地址：<br>
 * 
 * http://ifeve.com/google-guava-newcollectiontypes/<br>
 * 
 * @author homelink
 * 
 */
public class NewTypeCollection {

    public static void main(String[] args) {

       System.out.print( CharMatcher.JAVA_LETTER.matchesAnyOf("111"));

    }

}
