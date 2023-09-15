package real.a;

import java.util.*;

/*
*
有一个长度为n的正整数序列，小驼想移除掉里面的重复元素，但是小驼例想是对于每种元素保留最后出现的那个。
* */
public class qunaer4数组去重 {


    public static int[] findQ (int n, int[] nums) {
        // write code here
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {10, 20, 10,99, 100, 100,99};

        int[] result = findQ(8, num);
        System.out.println(Arrays.toString(result));

    }


}

