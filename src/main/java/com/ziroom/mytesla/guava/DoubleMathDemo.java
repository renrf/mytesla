package com.ziroom.mytesla.guava;

import java.math.BigDecimal;

import com.google.common.math.DoubleMath;

/**
 * ����������<br>
 * ֻ�оٳ��õģ�����������о���׳ˡ�����ʽ��<br>
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
	 * �жϸ������ǲ���һ������
	 */
	System.out.println(DoubleMath.isMathematicalInteger(50.0d));
	/**
	 * doubleתint <br>
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
	System.out.println(DoubleMath.roundToInt(1.5d, java.math.RoundingMode.HALF_DOWN));

	/**
	 * ����С��
	 */
	System.out.println(new BigDecimal(-1.675d).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue());
    }
}
