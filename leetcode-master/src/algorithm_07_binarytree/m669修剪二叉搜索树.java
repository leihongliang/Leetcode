package algorithm_07_binarytree;

public class m669修剪二叉搜索树 {
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
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            root = root.right;
            root = trimBST(root, low, high);
        }else if (root.val > high) {
            root = root.left;
            root = trimBST(root, low, high);
        }else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
    public static TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }else if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(0);
        head.right = new TreeNode(4);
        head.left.right = new TreeNode(2);
        head.left.right.left = new TreeNode(1);
        TreeNode res = trimBST(head, 1,3);
        System.out.println(res);
    }
}
