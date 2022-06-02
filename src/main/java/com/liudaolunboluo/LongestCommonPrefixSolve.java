package com.liudaolunboluo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author zhangyunfan@fiture.com
 * @version 1.0
 * @ClassName: LongestCommonPrefixSolve
 * @date 2022/5/29
 */
public class LongestCommonPrefixSolve {

    public static void main(String[] args) {
        LongestCommonPrefixSolve longestCommonPrefixSolve = new LongestCommonPrefixSolve();
        System.out.println(longestCommonPrefixSolve.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                String temp = getCommonStrand(strs[i], strs[i + 1]);
                if ("".equals(temp)) {
                    break;
                }
                result = temp;
            }
            //从第三个开始和第一个和第二个的公共串找公共串
            else if (i != 1) {
                if (strs[i].startsWith(result)) {
                    continue;
                }
                String commonStrand = getCommonStrand(strs[i], result);
                if (commonStrand.length() == 0) {
                    result = "";
                    break;
                }
                result = commonStrand;
            }

        }
        return result;
    }

    private String getCommonStrand(String s1, String s2) {
        StringBuilder commonStr = new StringBuilder();
        String[] s1Arr = s1.split("");
        String[] s2Arr = s2.split("");
        for (int i = 0; i < s1Arr.length; i++) {
            if (i == s2Arr.length) {
                break;
            }
            if (s1Arr[i].equals(s2Arr[i])) {
                commonStr.append(s1Arr[i]);
            } else {
                break;
            }
        }
        return commonStr.toString();
    }
}
