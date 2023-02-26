package algorithm_10_dp;

public class p31_h337打家劫舍III {
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
    public static int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }
    static int[] robAction(TreeNode root) {
        int res[] = new int[2];
        if (root ==  null) return res;
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(4);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.right = new TreeNode(1);
        int res = rob(head);
        System.out.println(res);
    }
}
