package algorithm_13_math;

public class 剑指Offer39数组中出现次数超过一半的数字 {
    public static int majorityElement(int[] nums) {
        int flag = 0;
        int res = nums[0];

        for (int i = 0;  i < nums.length; i++) {
            if (flag == 0) res = nums[i];
            flag += res == nums[i] ? 1 : -1;
        }
        return res;
    }
}
