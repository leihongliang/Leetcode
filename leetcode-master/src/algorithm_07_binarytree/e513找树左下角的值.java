package algorithm_07_binarytree;

public class e513找树左下角的值 {
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
    private static int maxDepth = -1;
    private static int res = 0;
    public static int findBottomLeftValue(TreeNode root) {
        res =  root.val;
        findLeftValue(root, 0);
        return res;
    }
    private static void findLeftValue (TreeNode root,int depth) {
        depth ++;
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
        }
        if (root.left != null) findLeftValue(root.left, depth);
        if (root.right != null) findLeftValue(root.right, depth);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);
        int res = findBottomLeftValue(head);
        System.out.println(res);
    }
}
