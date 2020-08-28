package com.acm.leecode.array;

import java.util.Arrays;

/**
 * @author ymj
 * @Date： 2020/7/17 16:28
 * @description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Main283 {

    /** 过于复杂*/
    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                if (i == nums.length - 1){
                    break;
                } else {
                    if (nums[i+1] == 0) {
                        for (int j = i+1; j < length - 1; j++) {
                            nums[j] = nums[j+1];
                            nums[j+1] = 0;
                        }
                        length -= 1;
                        i--;
                    }else { // 只需换一次
                        nums[i] = nums[i+1];
                        nums[i+1] = 0;
                    }
                }
            }
        }
    }

    /** 前后指针*/
    public void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = nums[cur];
                nums[cur] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        for (int i :
                nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
        new Main283().moveZeroes(nums);
        for (int i :
                nums) {
            System.out.print(i + ", ");
        }
    }
}
