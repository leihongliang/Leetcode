package algorithm_07_binarytree;

public class e111二叉树的最小深度 {
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

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depthleft = minDepth(root.left);
        int depthright = minDepth(root.right);
        if(root.left == null) return depthright + 1;
        if(root.right == null) return depthleft + 1;
        return Math.min(depthleft,depthright) + 1;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        int res = minDepth(head);
        System.out.println(res);
    }
}
