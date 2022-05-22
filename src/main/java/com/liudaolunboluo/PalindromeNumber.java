package com.liudaolunboluo;

/**
 * @author zhangyunfan@fiture.com
 * @version 1.0
 * @ClassName: PalindromeNumber
 * @Description: 回文数
 * @date 2022/5/22
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xstr = String.valueOf(x);
        StringBuilder str = new StringBuilder();
        str.append(x);
        return str.reverse().toString().equals(xstr);
    }
}
