package algorithm_09_greedy;

import java.io.BufferedReader;
//import java.io.IOException;

class Solution {
    public int jump(int[] nums) {
        int end = 0;// 当前能跳的范围
        int max = 0;//当前两跳的范围
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {//决定跳到哪去
                end = max;
                res++;
            }
        }
        return res;
    }
}
public class m45跳跃游戏2 {
    public static void main(String[] args) {
//        int[] nums = {1,2,1,1,1};
        int[] nums = {2,3,1,1,4};
        int ret = new Solution().jump(nums);
        System.out.print(ret);
    }
}