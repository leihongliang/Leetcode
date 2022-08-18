package algorithm_07_binarytree;

public class m106从中序与后序遍历序列构造二叉树 {
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
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public static TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if(inRight - inLeft < 0) return null;
        if (inRight - inLeft == 0) {
            return new TreeNode(inorder[inLeft]);
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if( inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = helper(inorder, inLeft, rootIndex - 1,
                postorder, postLeft, postLeft + (rootIndex - inLeft)- 1);
        root.right = helper(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight-1);
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
//        int[] inorder = {4,2,5,1,6,3,7};
//        int[] postorder = {4,5,2,6,7,3,1};
        int[] inorder = {2,1};
        int[] postorder = {2,1};
        TreeNode res = buildTree(inorder, postorder);
        System.out.println(res);
    }
}
