package algorithm_13_math;

import java.util.HashMap;
import java.util.HashSet;

public class 数组出现 {
    //只出现一次
    //每两个相异的数执行异或运算之后，结果为1；
    //每两个相同的数异或之后，结果为0，
    //任何数与0异或，结果仍为自身。
    public static int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        return x;
    }
    public static int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    //唯一重复数
    public static int repeatNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        for (int i = 1; i < nums.length; i++) {
            x = x ^ i;
        }
        return x;
    }
    public static int repeatNumber2(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums1 = {4,1,2,1,2};
        int[] nums2 = {1,2,3,4,2};
        System.out.println(singleNumber(nums1));
        System.out.println(repeatNumber2(nums2));

    }
}
