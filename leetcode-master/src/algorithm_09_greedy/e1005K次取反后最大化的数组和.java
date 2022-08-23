package algorithm_09_greedy;

import java.util.Arrays;

class Solution2 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int max = 0;//positive
        Arrays.sort(nums);
        int res  = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (k > 0) {
                    res -= nums[i];
                    k--;
                }else {
                    res += nums[i];
                }
            }
            if (nums[i] >= 0) {
                if (k > 0){
                    if (k % 2 == 1 ) {
                        res -= nums[i];
                        k = 0;
                    }
                }else {
                    res += nums[i];
                }

            }
        }
        return res;
    }
}
public class e1005K次取反后最大化的数组和 {
    public static void main(String[] args) {
        int[] nums = {3,-1,0,2};
//        int[] nums = {2,-3,-1,5,-4};
        int ret = new Solution2().largestSumAfterKNegations(nums, 3);
        System.out.print(ret);
    }
}