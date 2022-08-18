package algorithm_07_binarytree;

public class e700二叉搜索树中的搜索 {
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
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val == root.val) return root;
        TreeNode left = searchBST(root.left, val);
        if (left.val == val ) {
            return left;
        }
        TreeNode right = searchBST(root.right, val);
        if (right.val == val ) {
            return right;
        }
        return null;

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(1);
//        head.left.left.right = new TreeNode(5);
        head.right.left = new TreeNode(2);
        head.right.right = new TreeNode(5);
        TreeNode res = searchBST(head, 5);
        System.out.println(res);
    }
}
