package com.liudaolunboluo;

/**
 * @author zhangyunfan@fiture.com
 * @version 1.0
 * @ClassName: RemovingElements
 * @Description: 移除元素
 * @date 2022/6/16
 */
public class RemovingElements {

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
