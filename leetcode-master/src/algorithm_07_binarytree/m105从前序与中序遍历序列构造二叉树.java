package algorithm_07_binarytree;

public class m105从前序与中序遍历序列构造二叉树 {
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
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }
    public static TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preRight < preLeft || inRight < inLeft) return null;
        //if(preRight = preLeft )
        int rootVal = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preLeft + 1, preLeft + rootIndex - inLeft,
                inorder, inLeft, rootIndex - 1);
        root.right = helper(preorder, preLeft + rootIndex - inLeft + 1, preRight,
                inorder, rootIndex + 1, inRight);
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
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode res = buildTree(preorder, inorder);
        System.out.println(res);
    }
}
