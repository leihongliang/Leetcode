package algorithm_09_greedy;

import java.util.Arrays;

public class m376摆动序列 {
    public static int wiggleMaxLength(int[] nums) {
        int dif = 0;
        int res = 1;
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            dif = nums[i] - nums[i - 1];
            if ((pre >= 0 && dif < 0)||(pre <= 0 && dif > 0)) {
                res ++;
            }else {
                continue;
            }
            pre = dif;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(g));
    }
}
