package algorithm_09_greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class m406根据身高重建队列 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }
        return que.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(reconstructQueue(people));
    }
}
