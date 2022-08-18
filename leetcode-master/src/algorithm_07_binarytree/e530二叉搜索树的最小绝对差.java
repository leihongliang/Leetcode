package algorithm_07_binarytree;

public class e530二叉搜索树的最小绝对差 {
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

    static int res = Integer.MAX_VALUE;
    static int tmp = -1;
    public static int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        helper(root);
        return res;
    }
    public static void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (tmp != -1) res = Math.min(res, root.val - tmp);
        tmp = root.val;
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        int res = getMinimumDifference(head);
        System.out.println(res);
    }
}
