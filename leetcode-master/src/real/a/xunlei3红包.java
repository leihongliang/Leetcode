package real.a;

/*
为了回馈广大会员的支持，迅雷计划年度运营活动将送出最多1万个红包，每个红包的金额随机(0-10000分之间)，生成好的红包会放入一个队列。
现需要从左到右将队列分为3段，作为白金会员、超级会员、年费超级会员的红包池，但是需要满足白金会员红包池总金额<=超级会员红包池总金额<=年费超级会员红包池总金额，满足此条件的分割方案一共有多少种？

示例1:

输入：nums = [1,1,1]
输出：1
解释：唯一一种好的分法是将 nums 分成 [1] [1] [1]。
示例2

输入：nums = [1,2,2,2,5,0]
输出：3
解释：nums 总共有 3 种好的分法：
[1] [2] [2,2,5,0]
[1] [2,2] [2,5,0]
[1,2] [2,2] [5,0]

* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class xunlei3红包 {

        public static void main(String[] args) {
            int[] salaries = {5000, 1000, 2000};
            int[][] subordinates = {{2, 3}, {}, {}};

        }

    public int waysToSplit(int[] nums) {
        // 在这⾥写代码
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        int sum1 = 0;
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            sum1 += nums[i];
            int sum2 = 0;
            for (int j = i + 1; j <= n - 2; j++) {
                sum2 += nums[j];
                int sum3 = total - sum1 -sum2;
                if (sum1 <= sum2 && sum2 <= sum3) {
                    count++;
                }
            }
        }
        return count;
    }


}
