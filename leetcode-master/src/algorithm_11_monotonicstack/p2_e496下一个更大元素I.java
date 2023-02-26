package algorithm_11_monotonicstack;

import java.lang.reflect.Array;
import java.util.*;

public class p2_e496下一个更大元素I {
    public static int[] nextGreaterElement0(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }
        temp.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[temp.peek()]) {
                temp.add(i);
            } else {
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]) {
                    if (hashMap.containsKey(nums2[temp.peek()])){
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // process nums1
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++){
            hashMap.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    if (hashMap.containsKey(nums2[stack.peek()])) {
                        Integer index = hashMap.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;


    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));

    }
}
