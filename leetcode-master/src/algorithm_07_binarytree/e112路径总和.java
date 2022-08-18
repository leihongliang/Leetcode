package algorithm_07_binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class e112路径总和 {
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
    /**bfs*/
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();
        queue.offer(root);
        sum.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            int tmpSum = sum.poll();
            if (tmpNode.left != null) {
                queue.offer(tmpNode.left);
                sum.offer(tmpSum + tmpNode.left.val);
            }
            if (tmpNode.right != null) {
                queue.offer(tmpNode.right);
                sum.offer(tmpSum + tmpNode.right.val);
            }
            if (tmpNode.left == null && tmpNode.right == null) {
                if (tmpSum == targetSum) return true;
            }
        }
        return false;
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) return true;
        if (hasPathSum(root.left , targetSum)) return true;
        if (hasPathSum(root.right , targetSum)) return true;
        return false;
    }
    public static boolean hasPathSum0(TreeNode root, int targetSum) {
        if (root == null) return false;
//        if (root.left == null && root.right == null && targetSum == 0) return true;
        if (root.left == null && root.right == null ) {
            targetSum -= root.val;
            if (targetSum == 0) return true;
            targetSum += root.val;
        }
        if (root.left != null) {
            targetSum -= root.left.val;
            if (hasPathSum(root.left , targetSum)) return true;
            targetSum += root.left.val;
        }
        if (root.right != null) {
            targetSum -= root.right.val;
            if (hasPathSum(root.right , targetSum)) return true;
            targetSum += root.right.val;
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);
        boolean res = hasPathSum(head, 4);
        System.out.println(res);
    }
}
