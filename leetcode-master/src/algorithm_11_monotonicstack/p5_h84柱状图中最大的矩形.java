package algorithm_11_monotonicstack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class p5_h84柱状图中最大的矩形 {
    public static int largestRectangleArea(int[] heights){
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int w = i - left - 1;
                        int h = heights[mid];
                        res = Math.max(res, w*h);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        int res = largestRectangleArea(height);
        System.out.println(res);

    }
}
