package real.a;

import java.util.*;
/*
挑选
小丽有一串有n个珠子的漂亮手链，其上的珠子颜色(用整数代表)从左到右分别为a1 a2..a，小丽觉得其中反复出现相同颜色混杂其中是不美观的。小丽想将其中重复颜色的珠子去一下重，只保留最右边的那一颗，其余珠子相对位置保持不变。因为珠子实在太多了，请你帮帮小丽。
输入描述
第一行1个整数n，表示珠子数量。
第二行n个整数a1 a2...an，表示珠子颜色
输出描述
输出一行若干个整数表示去重后的珠子颜色，
样例描入
8
1 2 1 3 4 2 4 4
样例输出
1 3 2 4
* */
public class webank2数组去重 {

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



