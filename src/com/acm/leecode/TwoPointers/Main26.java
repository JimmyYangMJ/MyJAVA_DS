package com.acm.leecode.TwoPointers;

/**26. Remove Duplicates from Sorted Array ɾ�����������е��ظ���
 *
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 *
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 *
 * ʾ��?1
 * �������� nums = [1,1,2],
 *
 * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��
 *
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author ymj
 * @Date�� 2019/12/19 20:45
 */
public class Main26 {

    /**
     * ����Ĺؼ������ڣ� �����������Ѿ��ź����
     * ��ָ�룬��ָ��
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // �����ָ�� �� ��ָ��
        // ����ָ��֮ǰ��Ԫ�� ��Ū�õģ� ��ָ��ָ���Ԫ����Ҫɾ���ģ�
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
