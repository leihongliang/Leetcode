package algorithm_09_greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class m56合并区间 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];
        int[] tmp = new int[]{left, right};
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                tmp = new int[]{left, right};
                res.add(tmp);
                left = intervals[i][0];
            }
            if (intervals[i][1] > right) {
                right = intervals[i][1];
            }
        }
        tmp = new int[]{left, right};
        res.add(tmp);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
//        int[][] s ={{1,3},{2,6},{8,10},{15,18}};
        int[][] s ={{1,1},{1,3},{1,5}};
        int[][] res = merge(s);
        System.out.println(Arrays.toString(res));
    }
}
