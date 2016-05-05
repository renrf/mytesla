package com.ziroom.mytesla.guava;

import java.math.BigDecimal;

import com.google.common.math.DoubleMath;

/**
 * 浮点数运算<br>
 * 只列举常用的，更多的自行研究如阶乘、二项式等<br>
 *
 * @author homelink
 *
 */
public class DoubleMathDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
	/**
	 * 判断浮点数是不是一个整数
	 */
	System.out.println(DoubleMath.isMathematicalInteger(50.0d));
	/**
	 * double转int <br>
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
	System.out.println(DoubleMath.roundToInt(1.5d, java.math.RoundingMode.HALF_DOWN));

	/**
	 * 保留小数
	 */
	System.out.println(new BigDecimal(-1.675d).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue());
    }
}
