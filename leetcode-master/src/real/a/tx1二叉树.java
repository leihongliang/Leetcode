package real.a;

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
public class tx1二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int countPaths(TreeNode root) {
        return countPaths(root, 0, 0);
    }

    public static int countPaths(TreeNode root, int count_0, int count_1) {
        if (root == null) {
            return 0;
        }

        count_0 += (root.val == 0) ? 1 : 0;
        count_1 += (root.val == 1) ? 1 : 0;

        if (root.left == null && root.right == null) {
            // 到达叶子节点，判断是否满足条件
            return count_1 > count_0 ? 1 : 0;
        }

        int leftPaths = countPaths(root.left, count_0, count_1);
        int rightPaths = countPaths(root.right, count_0, count_1);

        return leftPaths + rightPaths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(0);

        int pathCount = countPaths(root);
        System.out.println(pathCount); // 输出2
    }

}



