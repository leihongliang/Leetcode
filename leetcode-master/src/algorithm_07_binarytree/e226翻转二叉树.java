package algorithm_07_binarytree;

public class e226翻转二叉树 {
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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right =root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println( head.right.right.right.val);
        TreeNode res = invertTree(head);
        System.out.println(res);
    }
}
