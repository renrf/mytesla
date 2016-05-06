package com.ziroom.mytesla.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.ziroom.mytesla.common.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.jcp.xml.dsig.internal.dom.ApacheCanonicalizer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author liumy  .
 * @time 2016/5/6　14:25
 * @email　 liumy46@ziroom.com
 */
public class StringDemo {


    public  static  void  main(String[] args){

        String str1 = Joiner.on(";").skipNulls().join(Arrays.asList("a", "b", null, "c")); //a;b;c
        System.out.println(str1);
        String str2 = Joiner.on(",").join(Arrays.asList(1, 5, 7));
        System.out.println(str2);  //1,5,7
        String[] str3={"1","2"};
        System.out.println(Joiner.on(",").join(str3));  //1,2

        String string="";
        String string1=null;
        String string2="      ";
        //guava
        System.out.println(Strings.isNullOrEmpty(string)+","+Strings.isNullOrEmpty(null)+","+Strings.isNullOrEmpty(string2));  //true,true,false
        //stringUtil
        System.out.println(StringUtil.isEmpty(string)+","+StringUtil.isEmpty(string1)+","+StringUtil.isEmpty(string2));  //true,true,true
        //Apache
        System.out.println(StringUtils.isEmpty(string)+","+StringUtils.isEmpty(string1)+","+StringUtils.isEmpty(string2));  //true,true,false

        String[] strings={"123","23233",null};
        System.out.println(StringUtil.isEmpty(strings)); //true
        String[] strings1={"123","23233","444"};
        System.out.println(StringUtil.isEmpty(strings1)); //false


        //java
        String[] token="one,two,three".split(",");
        // Apache StringUtils...  
        String[] tokens1=StringUtils.split("one,two,three",',');
          // Google Guava splitter...  
        Iterable<String> tokens2= Splitter.on(",").split("one,two,three");
        for(String str:tokens2){
            System.out.println(str);
        }

        Iterable<String> tokens3= Splitter.on(",").trimResults().omitEmptyStrings().split(",one   ,two,three");
        for(String str:tokens3){
            System.out.println(str);
        }
        //one
        //two
        //three


        //2.1 返回Iterable<String>对象,其实是java.util.Collections$UnmodifiableMap实例
        String s = "key3=value3,key2=value2,key1=value1 ";
        Splitter.MapSplitter mapSplitter = Splitter.on(",").trimResults().withKeyValueSeparator("=");
        Map<String, String> map = mapSplitter.split(s);
        System.out.println(map.getClass().getName());  //java.util.Collections$UnmodifiableMap
        System.out.println(map);
//      map.put("key4","value4");//map只读,此处将抛出java.lang.UnsupportedOperationException


    }

}
