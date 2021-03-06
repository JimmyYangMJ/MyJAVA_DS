package com.acm.leecode.TwoPointers;

/**26. Remove Duplicates from Sorted Array 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例?1
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ymj
 * @Date： 2019/12/19 20:45
 */
public class Main26 {

    /**
     * 本题的关键点在于， 给的数组是已经排好序的
     * 快指针，慢指针
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // 定义快指针 和 慢指针
        // （慢指针之前的元素 是弄好的， 慢指针指向的元素是要删除的）
        int fast = 0, slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        new Main26().removeDuplicates(new int[]{1,2,2,3,3,4,5,5});
    }
}
