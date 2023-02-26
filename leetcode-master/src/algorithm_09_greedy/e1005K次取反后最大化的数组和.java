package algorithm_09_greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution2 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) nums[nums.length - 1] = -nums[nums.length - 1];
        return Arrays.stream(nums).sum();
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