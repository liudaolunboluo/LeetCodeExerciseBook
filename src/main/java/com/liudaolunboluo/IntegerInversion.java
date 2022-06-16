package com.liudaolunboluo;

/**
 * @author zhangyunfan@fiture.com
 * @version 1.0
 * @ClassName: IntegerInversion
 * @Description: 整数反转
 * @date 2022/6/16
 */
public class IntegerInversion {

    public static void main(String[] args) {
        IntegerInversion integerInversion = new IntegerInversion();
        System.out.println(integerInversion.reverse(-2147483648));
    }

    public int reverse(int x) {
        if (x < Integer.MIN_VALUE) {
            return 0;
        }
        if (x == 0) {
            return 0;
        }
        StringBuilder s;
        if (x < 0) {
            s = new StringBuilder(String.valueOf(x).substring(1, String.valueOf(x).length()));
        } else {
            s = new StringBuilder(String.valueOf(x));
        }
        String c = s.reverse().toString();
        Long a = Long.parseLong(c);
        if (a > Integer.MAX_VALUE) {
            return 0;
        }
        int result = a.intValue();
        if (x < 0) {
            return -1 * result;
        } else {
            return result;
        }
    }
}
