package algorithm_07_binarytree;

import java.util.*;

public class e102二叉树的层序遍历 {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode tmp = queue.poll();
                itemList.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
                len--;
            }
            res.add(itemList);
        }
        return res;
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            while(len > 0 ) {
                TreeNode tmp = queue.poll();
                itemList.add(tmp.val);
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
                len--;
            }
            res.add(0, itemList);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrderBottom(head);
        System.out.println(res);
    }
}
