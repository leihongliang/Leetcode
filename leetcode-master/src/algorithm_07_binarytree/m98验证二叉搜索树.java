package algorithm_07_binarytree;

public class m98验证二叉搜索树 {
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
    private int prev = Integer.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null &&root.right.val >= root.val) {
            return false;
        }
        if (!isValidBST(root.left)) return false;
        if (!isValidBST(root.right)) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(1);
//        head.left.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(2);
//        head.right.right = new TreeNode(5);
        Boolean res = isValidBST(head);
        System.out.println(res);
    }
}
