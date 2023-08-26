package real.a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class a美团3 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();  // 输入数组长度
            int k = scanner.nextInt();  // 输入目标平均数
            int[] nums = new int[n];    // 存储输入的数组
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int maxLength = solve3(nums, n, k);  // 调用函数找到最长连续子数组长度
            System.out.println(maxLength);  // 输出结果
        }

        public static int findMaxSubarrayLength(int[] nums, int k) {
            int maxLength = -1;  // 初始化最长子数组长度为 -1，如果不存在满足条件的子数组，将保持该值
            int sum = 0;  // 用于记录当前窗口内元素的和
            int start = 0;       // 滑动窗口的起始位置

            for (int end = 0; end < nums.length; end++) {  // 遍历数组，不断移动窗口的结束位置
                sum += nums[end];  // 将当前元素加入窗口内
                // 如果窗口内的元素和大于目标平均数乘以窗口大小，缩小窗口
                while (sum > k * (end - start + 1)) {
                    sum -= nums[start];  // 移除窗口的第一个元素
                    start++;  // 移动窗口起始位置
                }

                // 如果窗口内的元素和等于目标平均数乘以窗口大小，更新最长子数组长度
                if (sum == k * (end - start + 1)) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }

            return maxLength;
        }

        // 定义一个方法，求解最长的平均数为k的连续子数组的长度
        public static int solve2(int[] a, int n, int k) {
            // 定义一个数组，存储前缀和
            int[] sum = new int[n + 1];

            // 遍历数组a，计算前缀和
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + a[i - 1];
            }

            // 定义一个变量，记录最终的答案
            int ans = -1;

            // 从n开始，递减地枚举子数组的长度
            for (int len = n; len >= 1; len--) {
                // 定义一个标志，表示是否存在平均数为k的子数组
                boolean flag = false;

                // 遍历所有可能的子数组的起始位置
                for (int i = 0; i <= n - len; i++) {
                    // 计算子数组的和，即sum[i + len] - sum[i]
                    int subSum = sum[i + len] - sum[i];

                    // 如果子数组的和等于k乘以长度，说明平均数为k，将标志设为true，并退出循环
                    if (subSum == k * len) {
                        flag = true;
                        break;
                    }
                }

                // 如果标志为true，说明存在平均数为k的子数组，将答案设为当前的长度，并退出循环
                if (flag) {
                    ans = len;
                    break;
                }
            }

            // 返回答案
            return ans;
        }
        public static int solve3(int[] nums, int n, int k) {
            // HashMap to store (sum, index) tuples
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0, maxLen = 0;

            // traverse the given array
            for (int i = 0; i < n; i++) {

                // accumulate sum
                sum += nums[i];

                // when subarray starts from index '0'
                if (sum == k)
                    maxLen = i + 1;

                // make an entry for 'sum' if it is
                // not present in 'map'
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }

                // check if 'sum-k' is present in 'map'
                // or not
                if (map.containsKey(sum - k)) {

                    // update maxLength
                    if (maxLen < (i - map.get(sum - k)))
                        maxLen = i - map.get(sum - k);
                }
            }

            return maxLen;
        }

            public int maxSubArrayLen(int[] nums, int k) {
                int res = 0;
                int[] dp = new int[nums.length + 1];
                for (int i = 1; i <= nums.length; i++) {
                    dp[i] = dp[i - 1] + nums[i - 1];
                }
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i; j < nums.length; j++) {
                        int s = dp[j + 1] - dp[i];
                        if (s == k) {
                            res = Math.max(res, j - i + 1);
                        }
                    }
                }
                return res;
            }

    }



