package com.ziroom.mytesla.guava;

import com.google.common.math.IntMath;

/**
 * ��������<br>
 * ֻ�оٳ��õģ�����������о���׳ˡ�����ʽ��<br>
 * LongMath��IntMath����,��������java.lang.Math
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
	 * ��ȫ�ӷ����������ʱ����Щ����������ʧ�ܶ����Ǻ������,java.lang.ArithmeticException: overflow <br>
	 * ��ʹ�ý��õ�һ������Ԥ�ϵ�ֵ
	 */
	// System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, 1));
	/**
	 * ��ȫ�˷����������ʱ����Щ����������ʧ�ܶ����Ǻ������,java.lang.ArithmeticException: overflow
	 *
	 */
	// System.out.println(IntMath.checkedMultiply(Integer.MAX_VALUE, 2));
	/**
	 * ��ȫ�����������ʱ����Щ����������ʧ�ܶ����Ǻ������,java.lang.ArithmeticException: overflow
	 *
	 */
	// System.out.println(IntMath.checkedPow(Integer.MAX_VALUE, 0));
	/**
	 * ��ȫ�������������ʱ����Щ����������ʧ�ܶ����Ǻ������,java.lang.ArithmeticException: overflow
	 *
	 */
	// System.out.println(IntMath.checkedSubtract(Integer.MIN_VALUE, 1));
	/**
	 * ���� <br>
	 * RoundingMode: <br>
	 * DOWN�����㷽�����루ȥβ���� <br>
	 * UP��Զ���㷽������ <br>
	 * FLOOR�������޴������� <br>
	 * CEILING���������޴������� <br>
	 * UNNECESSARY������Ҫ���룬����ô�ģʽ�������룬Ӧֱ���׳�ArithmeticException <br>
	 * HALF_UP����������������룬����x.5Զ���㷽������ <br>
	 * HALF_DOWN����������������룬����x.5���㷽������ <br>
	 * HALF_EVEN����������������룬����x.5�����ڵ�ż������
	 */
	System.out.println(IntMath.divide(5, 2, java.math.RoundingMode.DOWN));
	/**
	 * ȡģ
	 * 
	 */
	System.out.println(IntMath.mod(Integer.MAX_VALUE, 1));

    }
}
