package algorithm_09_greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class m452用最少数量的箭引爆气球 {
    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points,(a, b) -> {
            return a[0] - b[0];
        });
        int res  = 1;
        int left = points[0][0];
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] >= left && points[i][0] <= right || points[i][1] <= right && points[i][1] >= left){
                if (points[i][0] >= left) left = points[i][0];
                if (points[i][1] <= right) right = points[i][1];
            }else {
                left = points[i][0];
                right = points[i][1];
                res ++;
            }
        }
        return res;
    }
    public static int findMinArrowShots2(int[][] points) {
        Arrays.sort(points,(a, b) -> Integer.compare(a[0], b[0]));
        int res  = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if ( points[i][0] <= right){
                if (points[i][1] <= right) right = points[i][1];
            }else {
                right = points[i][1];
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] people = {{10,16},{2,8},{1,6},{7,12}};
        int[][] people = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots2(people));
    }
}
