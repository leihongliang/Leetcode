package algorithm_11_monotonicstack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class p1_m739每日温度 {
    public static int[] dailyTemperatures0(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
    public static int[] dailyTemperatures1(int[] temperatures) {
        int [] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++){
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return  res;
    }

    // 23.04.20
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));

    }
}
