package com.ziroom.mytesla.guava;

import com.google.common.math.IntMath;

/**
 * 整数运算<br>
 * 只列举常用的，更多的自行研究如阶乘、二项式等<br>
 * LongMath与IntMath类似,其他还用java.lang.Math
 *
 * @author homelink
 *
 */
public class IntMathDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
	/**
	 * 安全加法运算结果溢出时，这些方法将快速失败而不是忽略溢出,java.lang.ArithmeticException: overflow <br>
	 * 不使用将得到一个不可预料的值
	 */
	// System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, 1));
	/**
	 * 安全乘法运算结果溢出时，这些方法将快速失败而不是忽略溢出,java.lang.ArithmeticException: overflow
	 *
	 */
	// System.out.println(IntMath.checkedMultiply(Integer.MAX_VALUE, 2));
	/**
	 * 安全幂运算结果溢出时，这些方法将快速失败而不是忽略溢出,java.lang.ArithmeticException: overflow
	 *
	 */
	// System.out.println(IntMath.checkedPow(Integer.MAX_VALUE, 0));
	/**
	 * 安全减法运算结果溢出时，这些方法将快速失败而不是忽略溢出,java.lang.ArithmeticException: overflow
	 *
	 */
	// System.out.println(IntMath.checkedSubtract(Integer.MIN_VALUE, 1));
	/**
	 * 除法 <br>
	 * RoundingMode: <br>
	 * DOWN：向零方向舍入（去尾法） <br>
	 * UP：远离零方向舍入 <br>
	 * FLOOR：向负无限大方向舍入 <br>
	 * CEILING：向正无限大方向舍入 <br>
	 * UNNECESSARY：不需要舍入，如果用此模式进行舍入，应直接抛出ArithmeticException <br>
	 * HALF_UP：向最近的整数舍入，其中x.5远离零方向舍入 <br>
	 * HALF_DOWN：向最近的整数舍入，其中x.5向零方向舍入 <br>
	 * HALF_EVEN：向最近的整数舍入，其中x.5向相邻的偶数舍入
	 */
	System.out.println(IntMath.divide(5, 2, java.math.RoundingMode.DOWN));
	/**
	 * 取模
	 * 
	 */
	System.out.println(IntMath.mod(Integer.MAX_VALUE, 1));

    }
}
