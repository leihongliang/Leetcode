package algorithm_11_monotonicstack;

import java.util.*;

public class p3_m503下一个更大元素II {
    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        stack.push(0);
        for (int i = 1; i < nums.length * 2; i++) {
            if (nums[i % nums.length] <= nums[stack.peek()]) {
                stack.push(i % nums.length);
            } else {
                while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                    res[stack.peek()] = nums[i % nums.length];
                    stack.pop();
                }
                stack.push(i % nums.length);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,3};
        int[] res = nextGreaterElements(nums1);
        System.out.println(Arrays.toString(res));

    }
}
