package com.acm.leecode.TwoPointers;

/**
 * 27. Remove Element
 *  ����һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ�
 *  �������Ƴ���������³��ȡ�
 * �Ƴ�Ԫ��
 * @author ymj
 * @Date�� 2019/12/19 20:20
 */
public class Main27 {

    /** 1. ɾ��֮�����λ�ò�����������ָ�룬��ָ�룩
     *  2. ����ɾ�������λ�ÿɱ����� ���� ���� һǰһ�� ��ָ��
     */
    public int removeElement(int[] nums, int val) {
        // �����ָ�� �� ��ָ��
        // ����ָ��֮ǰ��Ԫ��Ū�õģ� ��ָ��ָ���Ԫ����Ҫɾ���ģ�
        int fast = 0, slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        new Main27().removeElement(new int[]{3, 2, 2, 3}, 3);
    }

}
