package real.a;

import java.util.*;
public class webank2 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] colors = new int[n];
            for (int i = 0; i < n; i++) {
                colors[i] = sc.nextInt();
            }
            sc.close();
            HashSet<Integer> set = new HashSet<>();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--) {
                if (!set.contains(colors[i])) {
                    list.addFirst(colors[i]);
                    set.add(colors[i]);
                }
            }
            for (int color : list) {
                System.out.print(color + " ");
            }
        }
}



