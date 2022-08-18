package algorithm_03_hashtable;

import java.util.*;

public class e15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l ++;
                }else if (sum > 0) {
                    r --;
                }else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l<r && nums[l] == nums[l + 1]) l++;
                    l++;
                    while (l<r && nums[r] == nums[r - 1]) r--;
                    r--;

                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1};
//        int[] nums = { 0, 0, 0};
        List a = threeSum(nums);
        System.out.println(a);
    }
}
