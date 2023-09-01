package test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] values = new int[n];
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {values[i] = in.nextInt(); }
        for (int i = 0; i < n; i++) {
            costs[i] = in.nextInt();
        }
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int h = in.nextInt();
            adj.get(a).add(new int[] {b, h});
            adj.get(b).add(new int[] {a, h});
        }
        long res = 0;

//        for (int i = 0; i < n; i++) {
//            List<int[]> nexts = adj.get(i);
//            for (int[] next: nexts) {
//                int j = next[0];
//                if (i == j) continue;
//                List<int[]> nextnexts = adj.get(i);
//                for (int[] nextnext: nextnexts) {
//                    int q = nextnext[0];
//                    if (q == j || q == i) continue;
//                    long sum = (long) costs[i] + costs[j] + costs[q] + next[1] + nextnext[1];
//                    if (sum > k) continue;
//                    long totalValue = (long) values[i] + values[j] + values[q];
//                    res = Math.max(res, totalValue);
//                }
//            }
//        }
        for (int i = 0; i < n; i++) {
            List<int[]> nei = adj.get(i);
            Iterator<int[]> it1 = nei.iterator();
            while (it1.hasNext()) {
                int[] e1 = it1.next();
                int j = e1[0];
                if (i != j) {
                    Iterator<int[]> it2 = nei.iterator();
                    while (it2.hasNext()) {
                        int[] e2 = it2.next();
                        int q = e2[0];
                        if (q != j && q != i) {
                            long sum = (long) costs[i] + costs[j] + costs[q] + e1[1] + e2[1];
                            if (sum <= k) {
                                long totalValue = (long) values[i] + values[j] + values[q];
                                res = Math.max(res, totalValue);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

}
