package algorithm_11_monotonicstack;

import java.util.Deque;
import java.util.LinkedList;

public class p4_h42接雨水 {
    public static int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[stack.peek()]) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int w = i - left - 1;
                        int h = Math.min(height[left], height[i]) - height[mid];
                        res += w * h;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);

    }
}
