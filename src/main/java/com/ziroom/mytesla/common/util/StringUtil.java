package com.ziroom.mytesla.common.util;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * @author liumy  .
 * @time 2016/5/5　16:10
 * @email　 liumy46@ziroom.com
 */
public class StringUtil {


    private static final int PAD_LIMIT = 8192;

    /**
     * @author liumy  .
     * @time 2016/5/5　16:10
     * @email　 liumy46@ziroom.com
     * <p>半角字符转全角字符</p>
     */
    public static String changeToFull(String str) {
        String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
        String[] decode = {"１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
                "！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",
                "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
                "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
                "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",
                "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
                "Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",
                "'", "\"", "，", "〈", "。", "〉", "／", "？"};
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int pos = source.indexOf(str.charAt(i));
            if (pos != -1) {
                result += decode[pos];
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    /**
     * 判断字符串是否为空
     *
     * @param chkStr
     * @return chkStr=null true
     * chkStr="123" false
     * chkStr="  "  true
     * chkStr=""  true
     */
    public static boolean isEmpty(String chkStr) {
        if (chkStr == null) {
            return true;
        } else {
            return "".equals(chkStr.trim()) ? true : false;
        }

    }


    /**
     * 判断字符串数组是否为空
     *
     * @param chkStrs return
     *                chkStrs==null   true
     *                chkStrs   内元素存在空值返回 true
     *                否则返回false
     */
    public static boolean isEmpty(String[] chkStrs) {
        if (chkStrs == null || chkStrs.length <= 0)
            return true;
        boolean isNull = false;
        for (String str : chkStrs) {
            if (isEmpty(str)) {
                isNull = true;
                break;
            }
        }
        return isNull;
    }


    /**
     * 在源字符串移除指定的字符串
     *
     * @param str
     * @param remove
     * @return
     */
    public static String removeStart(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.startsWith(remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
     * 从原字符串结尾移除子串
     *
     * @param str
     * @param remove
     * @return
     */
    public static String removeEnd(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }


    /**
     * 不区分大小写字符串比较
     *
     * @param strFirst
     * @param strTwo
     * @return
     */
    public static boolean equalsIgnoreCase(String strFirst, String strTwo) {
        return StringUtils.equalsIgnoreCase(strFirst, strTwo);
    }


    /**
     * <p>
     * 功能：字符串长度达不到指定长度时，在字符串右边补指定的字符.
     * </p>
     * <p/>
     * <pre>
     * 		StringUtil.rightPad(null, *, *)     = null
     * 		StringUtil.rightPad("", 3, 'z')     = "zzz"
     * 		StringUtil.rightPad("bat", 3, 'z')  = "bat"
     * 		StringUtil.rightPad("bat", 5, 'z')  = "batzz"
     * 		StringUtil.rightPad("bat", 1, 'z')  = "bat"
     * 		StringUtil.rightPad("bat", -1, 'z') = "bat"
     * </pre>
     *
     * @param str     源字符串
     * @param size    指定的长度
     * @param padChar 进行补充的字符
     * @return String
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(repeat(padChar, pads));
    }


    /**
     * 从左面补全字符串
     *
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return repeat(padChar, pads).concat(str);
    }


    /**
     * 从右面补全字符串
     *
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    /**
     * 从左面补全字符串
     *
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    /**
     * 字符串反转
     *
     * @param str
     * @return
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }


    /**
     * 字符串大小写切换
     *
     * @param str
     * @return
     */
    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] buffer = str.toCharArray();

        boolean whitespace = true;

        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
                whitespace = false;
            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
                whitespace = false;
            } else if (Character.isLowerCase(ch)) {
                if (whitespace) {
                    buffer[i] = Character.toTitleCase(ch);
                    whitespace = false;
                } else {
                    buffer[i] = Character.toUpperCase(ch);
                }
            } else {
                whitespace = Character.isWhitespace(ch);
            }
        }
        return new String(buffer);
    }


    /**
     * 获取标示位之前的字符串
     *
     * @param sourceStr
     * @param expr
     * @return
     */
    public static String substringBefore(String sourceStr, String expr) {
        if (isEmpty(sourceStr) || expr == null) {
            return sourceStr;
        }
        if (expr.length() == 0) {
            return sourceStr;
        }
        int pos = sourceStr.indexOf(expr);
        if (pos == -1) {
            return sourceStr;
        }
        return sourceStr.substring(0, pos);
    }

    /**
     * 截取
     *
     * @param sourceStr
     * @param expr
     * @return
     */
    public static String substringAfter(String sourceStr, String expr) {
        if (isEmpty(sourceStr) || expr == null) {
            return sourceStr;
        }
        if (expr.length() == 0) {
            return sourceStr;
        }

        int pos = sourceStr.indexOf(expr);
        if (pos == -1) {
            return sourceStr;
        }
        return sourceStr.substring(pos + expr.length());
    }


    /**
     * 在字符串中提取字母
     *
     * @param str
     * @return
     */
    public static String subStringLetter(String str) {
        if (isEmpty(str)) return null;
        return CharMatcher.JAVA_LETTER.retainFrom(str) == null ? null : CharMatcher.SINGLE_WIDTH.retainFrom(CharMatcher.JAVA_LETTER.retainFrom(str));
    }

    /**
     * 在字符串替换非字母字符
     *
     * @param str
     * @return
     */
    public static String replaceStringLetter(String str, String replaceStr) {
        if (isEmpty(str)) return null;
        if (replaceStr == null) return str;
        return CharMatcher.JAVA_LETTER.replaceFrom(str, replaceStr) == null ? null : CharMatcher.SINGLE_WIDTH.retainFrom(CharMatcher.JAVA_LETTER.replaceFrom(str, replaceStr));
    }


    /**
     * 字符串提取数字
     *
     * @param str
     * @return
     */
    public static String subStringDigit(String str) {
        if (isEmpty(str)) return null;
        return CharMatcher.JAVA_DIGIT.retainFrom("some text 899083 and more");
    }

    /**
     * 字符串提取小写字母
     *
     * @param str
     * @return
     */
    public static String subStringLowerCase(String str) {
        if (isEmpty(str)) return null;
        return CharMatcher.JAVA_LOWER_CASE.retainFrom(str);
    }


    /**
     * 字符串提取大写字母
     *
     * @param str
     * @return
     */
    public static String subStringUpperCase(String str) {
        if (isEmpty(str)) return null;
        return CharMatcher.JAVA_UPPER_CASE.retainFrom(str);
    }

    /**
     * 提取非中文字符
     *
     * @param str
     * @return
     */
    public static String subStringSingleWidth(String str) {
        if (isEmpty(str)) return null;
        return CharMatcher.SINGLE_WIDTH.retainFrom(str);
    }


    /**
     * 提取控制字符
     *
     * @param str
     * @return
     */
    public static String subStringJavaIsoControl(String str) {
        if (isEmpty(str)) return null;
        return CharMatcher.JAVA_ISO_CONTROL.retainFrom(str);
    }


    /**
     * InputStream转byte数组
     *
     * @param is
     * @return
     */
    public byte[] stream2Byte(InputStream is) {

        byte[] in_b = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            int i = -1;
            while ((i = is.read()) != -1) {
                os.write(i);

            }

            in_b = os.toByteArray();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return in_b;

    }


    /**
     * InputStream 转String
     *
     * @param is
     * @return
     */
    public String stream2String(InputStream is) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringWriter sw = new StringWriter();
            int i = -1;
            while ((i = br.read()) != -1) {
                sw.write(i);
            }
            return sw.getBuffer().toString();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;

    }


    /**
     * 判断是否包含中文汉字
     *
     * @param strName
     * @return
     */
    public boolean isChineseHave(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 根据Unicode编码完美的判断中文汉字和符号
     *
     * @param c
     * @return
     */
    private boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }


    /**
     * 判断是否只有中文汉字
     *
     * @param strName
     * @return
     */
    public boolean isChineseAll(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }


    private static String repeat(char ch, int repeat) {
        char[] buf = new char[repeat];
        for (int i = repeat - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }


    public static void main(String[] agrs) {

        String[] str = {"111", "123", "234"};
        System.out.println(isEmpty(str));
        System.out.println(subStringLetter(null));
        System.out.println(subStringJavaIsoControl("SOME \t\r\b text 899083 and more"));
    }


}
