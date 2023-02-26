package algorithm_06_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 剑指hOffer59I滑动窗口的最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && deque.peek() == nums[i - 1]){
                deque.poll();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.offer(nums[j]);
            if (i >= 0) {
                res[i] = deque.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
