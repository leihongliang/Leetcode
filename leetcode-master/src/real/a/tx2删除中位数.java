package real.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*
* 牛牛有一棵二叉树，该二叉树节点的权值为0/1
牛牛给你这棵二叉树，想让你告诉他该二叉树从根节点到叶子节点的所有路径中，节点"权值1的个数"比"权值0的个数"多1的路径有多少条呢。
返回路径数目。
输入
{1,0,0,1,0,#,1}
输出
2
* */
public class tx2删除中位数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int last = n * (n - 1) /2;
            for (int i = 0; i < n - 1; i++) {
                b[i] = in.nextInt() - 1;
                last -= b[i];
            }
            ArrayList<Integer> res = new ArrayList<>();
            res.add(a[last] * 2);
            LinkedList<Integer> list = new LinkedList<>();
            list.add(a[last]);
            for (int i = n - 2; i >=0; i--){
                add(list, a[b[i]]);
                int len = list.size();
                if (len % 2 == 0) {
                    int temp= list.get(len / 2) + list.get(len / 2 - 1);
                    res.add(temp);
                } else {
                    res.add(list.get(len / 2) * 2);
                }
            }
//            for (int i = res.size() - 1; i >= 0; i--) {
//                int cur = res.get(i);
//                if (cur % 2 == 0) {
//                    System.out.print(cur / 2);
//                } else {
//                    System.out.print((double) cur / 2);
//                }
//                if (i != 0) System.out.print(" ");
//            }
            double half = 0;
            for (int i = res.size() - 1; i >= 0; i--) {
                half = res.get(i) / 2.0;
                System.out.print(half);
                if (i != 0) System.out.print(" ");
            }

        }
    }

        public static void add(LinkedList<Integer> list, int num) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= num) {
                    list.add(i, num);
                    return;
                }
            }
            list.add(num);
        }
//    public static void add(LinkedList<Integer> list, int num) {
//        int low = 0;
//        int high = list.size() - 1;
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (list.get(mid) < num) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        list.add(low, num);
//    }


}



