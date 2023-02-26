package algorithm_07_binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class m剑指Offer32III从上到下打印二叉树 {
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
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode cur = queue.poll();
                if (layer % 2 == 0) {
                    list.add(cur.val);
                }else {
                    list.addFirst(cur.val);
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                len--;
            }
            layer++;
            res.add(list);
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
        List<List<Integer>> res = levelOrder(head);
        System.out.println(res.toString());
    }
}
