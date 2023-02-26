package algorithm_09_greedy;

import java.util.Arrays;

public class m435无重叠区间 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int res = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (edge <= intervals[i][0]) {
                edge = intervals[i][1];
            } else {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] people = {{10,16},{2,8},{1,6},{7,12}};
        int[][] people = {{1,22},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals(people));
    }
}
