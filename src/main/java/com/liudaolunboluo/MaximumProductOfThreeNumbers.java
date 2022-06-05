package com.liudaolunboluo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author zhangyunfan@fiture.com
 * @version 1.0
 * @ClassName: MaximumProductOfThreeNumbers
 * @date 2022/6/5
 */
public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        if (list.size() <= 3) {
            return list.stream().reduce(1, (a, b) -> a * b);
        }
        Collections.sort(list);
        int simple = Math.max(list.get(list.size() - 1) * list.get(list.size() - 2) * list.get(list.size() - 3),
                list.get(0) * list.get(1) * list.get(3));
        return Math.max(simple, list.get(0) * list.get(1) * list.get(list.size() - 1));
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers m = new MaximumProductOfThreeNumbers();
        System.out.println(m.maximumProduct(new int[] { 1, 2, 3 }));
    }
}
