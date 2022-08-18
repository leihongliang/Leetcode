package algorithm_07_binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class e145二叉树的后序遍历 {
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

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while(!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if(cur.right != null) {
                    stack.add(cur.right);
                }
                if(cur.left != null) {
                    stack.add(cur.left);
                }
            }
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
        List<Integer> res = preorderTraversal(head);
        System.out.println(res);
    }
}
