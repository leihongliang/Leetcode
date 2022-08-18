package algorithm_07_binarytree;

public class e235二叉搜索树的最近公共祖先 {
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val <= q.val && root.val >= p.val) {
            return root;
        }
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(2);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(4);
        TreeNode res = lowestCommonAncestor(head, head.left, head.left.right);
        System.out.println(res.val);
    }
}

