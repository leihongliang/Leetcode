package algorithm_03_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if ( map.containsKey(temp) ) {
                res[0] = i;
                res[1] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2,2};
        int[] res = twoSum(nums, 4);
        System.out.println(Arrays.toString(res));
    }
}
