package algorithm_07_binarytree;

import java.util.ArrayList;
import java.util.Arrays;

public class e501二叉搜索树中的众数 {
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
    static ArrayList<Integer> resList = new ArrayList<>();
    static int tmp = -1;
    static int count = 0;
    static int maxCount = 0;

    public static int[] findMode(TreeNode root) {
        helper(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    public static void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(tmp != -1 ) {
            if (root.val != tmp) {
                count = 1;
            }else {
                count ++;
            }
            if (count > maxCount) {
                maxCount = count;
                resList.clear();
                resList.add(root.val);
            }else if (count == maxCount) {
                resList.add(root.val);
            }
        }
        if(tmp == -1) {
            count = 1;
            maxCount = count;
            tmp = root.val;
            resList.add(tmp);
        }
        tmp = root.val;
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(1);
//        head.left.left = new TreeNode(1);
////        head.left.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(2);
//        head.right.right = new TreeNode(5);
        int[] res = findMode(head);
        System.out.println(Arrays.toString(res));
    }
}
