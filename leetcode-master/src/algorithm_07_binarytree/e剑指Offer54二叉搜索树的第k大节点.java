package algorithm_07_binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class e剑指Offer54二叉搜索树的第k大节点 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int res, k;
    public static int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    static void dfs (TreeNode root, int k) {
        if (root == null) return ;
        dfs(root.right, k);
        k--;
        if (k == 0) {
            res = root.val;
        }
        dfs(root.left, k);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(2);
        head.right = new TreeNode(4);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);
        int res = kthLargest(head, 1);
        System.out.println(res);
    }
}
