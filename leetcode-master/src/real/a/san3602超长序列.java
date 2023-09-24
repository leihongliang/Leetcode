package real.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
有一个长度无限长的自然数序列 A，下标从 0 开始。初始时所有数均为 0。先进行 n 次修改，然后进行 m 次查询。
每次修改给出三个数 l，r，x，将[l, r] 中的每一个数变成它与 x 的异或值。
每次查询给出一个数字 p表示查询 A_p 的值。
输入描述
第一行两个整数n，m，意义如上文所述。
接下来n行3个整数l，r，x，意义如上文所述。
接下来m行1个整数p，意义如上文所述。
输出描述
输出m行每行一个整数，表示答案。
样例输入
2 2
1 5 1
3 7 2
4
6
样例输出
3
2

*/
import java.util.*;


public class san3602超长序列 {
    static final int N = 100000;

    static int[] a = new int[N];

    static class Node {
        int l, r;
        int val;
        int lazy;
    }


    static Node[] tree = new Node[N * 4];


    static void build(int i, int l, int r) {
        tree[i] = new Node();
        tree[i].l = l;
        tree[i].r = r;
        tree[i].val = 0;
        tree[i].lazy = 0;
        if (l == r) return;
        int mid = (l + r) / 2;
        build(i * 2, l, mid);
        build(i * 2 + 1, mid + 1, r);
    }

    static void pushDown(int i) {
        if (tree[i].lazy != 0) {
            tree[i * 2].val ^= tree[i].lazy;
            tree[i * 2 + 1].val ^= tree[i].lazy;
            tree[i * 2].lazy ^= tree[i].lazy;
            tree[i * 2 + 1].lazy ^= tree[i].lazy;
            tree[i].lazy = 0;
        }
    }


    static void update(int i, int l, int r, int x) {
        if (l <= tree[i].l && r >= tree[i].r) {
            tree[i].val ^= x;
            tree[i].lazy ^= x;
            return;
        }
        pushDown(i);
        int mid = (tree[i].l + tree[i].r) / 2;
        if (l <= mid) update(i * 2, l, r, x);
        if (r > mid) update(i * 2 + 1, l, r, x);
    }

    // 定义一个函数查询线段树
    static int query(int i, int p) {
        if (tree[i].l == tree[i].r) return tree[i].val;
        pushDown(i);
        int mid = (tree[i].l + tree[i].r) / 2;
        if (p <= mid) return query(i * 2, p);
        else return query(i * 2 + 1, p);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        build(1, 0, N - 1);
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            update(1, l, r, x);
        }
        for (int i = 0; i < m; i++) {
            int p = sc.nextInt();
            System.out.println(query(1, p));
        }
    }
}














