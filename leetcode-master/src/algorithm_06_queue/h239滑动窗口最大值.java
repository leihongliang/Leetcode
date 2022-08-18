package algorithm_06_queue;

import java.util.*;

class MonotonicQueue{
    Deque<Integer> deque = new LinkedList<>();
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }
    void add(int val) {// 不为空且比最后一个数大
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }
    int peek() {
        return deque.peek();
    }
}

class h239滑动窗口最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int num = 0;
        MonotonicQueue queue = new MonotonicQueue();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[num++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            res[num++] = queue.peek();
        }
        return res;
    }
    // 1.2 不用外置函数
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int num = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(nums[i]);
        }
        res[num++] = deque.peek();// 赋初值
        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && nums[i - k] == deque.peek()) {// 判断出去的值是否是最大值
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
            res[num++] = deque.peek();
        }
        return res;
    }
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        int[] res = new int[n - k + 1];
        res[0] = deque.peekFirst();
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if(nums[i - k] == deque.peekFirst()) {// 判断出去的值是否是最大值
                deque.pollFirst();
            }
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int[] res = maxSlidingWindow3(nums, 4);
        System.out.println(Arrays.toString(res));
    }
}

