package algorithm_07_binarytree;

public class e110平衡二叉树 {
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

    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);// 左
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);// 右
        if(rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) {// 中
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;
        return true;
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);
        boolean res = isBalanced2(head);
        System.out.println(res);
    }
}
