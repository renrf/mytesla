package com.ziroom.mytesla.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 格式化数字工具类
 * @author zhangtb
 * @date 2016-3-11 22:27:54
 */
public class NumberUtil {
	
	/**
	 * 将string类型的分，转换为string类型的带两位小数位的元
	 * @param numberStr
	 * @return
	 */
	public static String format(String numberStr) {
		DecimalFormat dFormat = new DecimalFormat("0.00");
		BigDecimal bigDecimal = new BigDecimal(numberStr);
		Double shouldPay = bigDecimal.divide(new BigDecimal("100")).doubleValue();
		return dFormat.format(shouldPay);
	}
	
	/**
	 * 将分转换成元
	 * @param numberStr String类型的分
	 * @return
	 */
	public static double formatToInt(String numberStr) {
		BigDecimal bigDecimal = new BigDecimal(numberStr);
		return bigDecimal.divide(new BigDecimal("100")).doubleValue();
	}
	
	/**
	 * 将int类型的分转换为int类型的元
	 * @param number
	 * @return
	 */
	public static int formatToInt(Integer number) {
		BigDecimal bigDecimal = new BigDecimal(number);
		return bigDecimal.divide(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
	}
	
	/**
	 * 将元转换成分
	 * @param numberStr  元
	 * @param defaultValue  默认
	 * @return
	 */
	public static int formatToInt(String numberStr, int defaultValue) {
		try {
			BigDecimal bigDecimal = new BigDecimal(numberStr);
			return bigDecimal.multiply(new BigDecimal("100")).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}
	
	/**
	 * 将元转换成分
	 * @param numberStr     元
	 * @param defaultValue  分
	 * @return
	 */
	public static String formatToString(String numberStr, String defaultValue) {
		try {
			BigDecimal bigDecimal = new BigDecimal(numberStr);
			return bigDecimal.multiply(new BigDecimal("100")).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}
	
	/**
	 * 通过总记录条数,每页条数获取总页数
	 * @param totalCount
	 * @param pageSize
	 * @return
	 */
	public static int getTotalPage(int totalCount,int pageSize) {
		if(totalCount%pageSize == 0){
			return totalCount/pageSize;
		}
		return totalCount/pageSize + 1;
	}
	
	/**
	 * 转换空整形,传入的参数如果为空,则返回0,否则返回传入的参数
	 * @param number
	 * @return
	 */
	public static int convertInteger(Integer number) {
		if(number == null){
			return 0;
		}
		return number;
	}
	
	/**
	 * 转换空整形,传入的参数如果为空,则返回0,否则返回传入的参数
	 * @param number
	 * @return
	 */
	public static int convertInteger(Object number) {
		if(number == null){
			return 0;
		}
		if(number instanceof String){
			return (new Integer((String)number)).intValue();
		}
		if(number instanceof BigDecimal){
			return (new BigDecimal(number.toString())).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		}
		return (int)number;
	}
	
	/**
	 * 字符串转换成整数，不合法的统一返回null
	 * @param number
	 * @return
	 */
	public static Integer strToInteger(String number) {
		if(StringUtils.isBlank(number)) {
			return null;
		}
		if(!isInteger(number)) {
			return null;
		}
		return Integer.valueOf(number);
	}
	
	/**
	 * 判断是否为整数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * <p>将一个对象转换成int类型</p>
	 * <pre>
	 * StringUtil.toInt(null) = 0;
	 * StringUtil.toInt("") = 0;
	 * StringUtil.toInt(" string ") = 0;
	 * StringUtil.toInt("123") = 123;
	 * StringUtil.toInt(" 123 ") = 0;
	 * </pre>
	 * @author zhangtb
	 * @date 2016-4-20 9:28:08
	 * @param obj
	 * @param defaultValue 默认值
	 * @return
	 */
	public static int toInt(Object obj) {
		if (obj != null) {
			String s = obj.toString();
			if (s != null && !"".equals(s.trim())) {
				if (s.matches("\\d+")) {
					return Integer.parseInt(s);
				}
			}
		}
		return toInt(obj, 0);
	}

	/**
	 * <p>将一个对象转换成int类型</p>
	 * <pre>
	 * StringUtil.toInt(null, 0) = 0;
	 * StringUtil.toInt("", 0) = 0;
	 * StringUtil.toInt(" string ", 0) = 0;
	 * StringUtil.toInt("123", 0) = 123;
	 * StringUtil.toInt(" 123 ", 0) = 0;
	 * </pre>
	 * @author zhangtb
	 * @date 2016-4-20 9:28:08
	 * @param obj
	 * @param defaultValue 默认值
	 * @return
	 */
	public static int toInt(Object obj, int defaultValue) {
		if (obj != null) {
			String s = obj.toString();
			if (s!=null && !"".equals(s.trim())) {
				if (s.matches("-?\\d+")) {
					return Integer.parseInt(s);
				}
			}
		}
		return defaultValue;
	}



	/**
	 * 判断当前值是否为整数
	 *
	 * @param value
	 * @return
	 */
	public static boolean isInteger(Object value) {
		if (value==null) {
			return false;
		}
		String mstr = value.toString();
		Pattern pattern = Pattern.compile("^-?\\d+$");
		return pattern.matcher(mstr).matches();
	}

	/**
	 * 判断当前值是否为数字(包括小数)
	 *
	 * @param value
	 * @return
	 */
	public static boolean isDigit(Object value) {
		if (value==null) {
			return false;
		}
		String mstr = value.toString();
		Pattern pattern = Pattern.compile("^-?[0-9]*.?[0-9]*$");
		return pattern.matcher(mstr).matches();
	}



	public static void main(String[] args) {
		/*System.out.println(format("0.01"));
		System.out.println(format("0.1"));
		System.out.println(format("1"));
		System.out.println(format("10"));
		System.out.println(format("100"));
		System.out.println(format("1000"));
		System.out.println(format("10000"));*/
		
		System.out.println(formatToInt("0.00005", 0));
		System.out.println(formatToString("0.00005", "0"));
	}

}
