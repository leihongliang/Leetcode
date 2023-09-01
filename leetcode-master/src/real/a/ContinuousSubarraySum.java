package real.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        // 使用哈希表记录前缀和与索引的映射
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // 初始化，确保起始位置的前缀和为0
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (k != 0) {
                prefixSum %= k;
            }

            if (prefixSumMap.containsKey(prefixSum)) {
                if (i - prefixSumMap.get(prefixSum) > 1) {
                    return true;
                }
            } else {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int num = sc.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(checkSubarraySum(nums, k));
    }
}
