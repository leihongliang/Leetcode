package algorithm_09_greedy;

import java.util.Arrays;

public class e455分发饼干 {
    /**
     * 双排序，最小size喂最小greed
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int child = 0;
        for(int i = 0; i < s.length && child < g.length; i++) {
            if (s[i] >= g[child]) {
                res++;
                child++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }
}
