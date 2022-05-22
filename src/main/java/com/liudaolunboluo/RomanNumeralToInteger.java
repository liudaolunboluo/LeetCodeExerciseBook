package com.liudaolunboluo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyunfan@fiture.com
 * @version 1.0
 * @ClassName: RomanNumeralToInteger
 * @Description: 罗马数字转整数
 * @date 2022/5/22
 */
public class RomanNumeralToInteger {

    private static final Map<String, Integer> NUMBER_DIC = new HashMap<>();

    static {
        NUMBER_DIC.put("I", 1);
        NUMBER_DIC.put("V", 5);
        NUMBER_DIC.put("X", 10);
        NUMBER_DIC.put("L", 50);
        NUMBER_DIC.put("C", 100);
        NUMBER_DIC.put("D", 500);
        NUMBER_DIC.put("M", 1000);
    }

    public int romanToInt(String s) {
        String[] sArr = s.split("");
        int res = 0;
        int pre = 0;
        for (int i = 0; i < sArr.length; i++) {
            String s1 = sArr[i];
            int sn = NUMBER_DIC.get(s1);
            if (i < sArr.length - 1 && NUMBER_DIC.get(sArr[i + 1]) > sn) {
                pre = sn;
                continue;
            }
            if (sn > pre && pre != 0) {
                res = res + sn - pre;
                pre = 0;
            } else {
                res = res + sn;
                pre = sn;
            }

        }
        return res;
    }
}
