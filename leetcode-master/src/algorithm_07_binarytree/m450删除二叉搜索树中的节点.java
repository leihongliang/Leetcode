package algorithm_07_binarytree;

public class m450删除二叉搜索树中的节点 {
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
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root;
            }else {
                TreeNode tmp = root.right;//引用
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                tmp.left = root.left;
                root = root.right;//删除
                return root;
            }
        }else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.left, key);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
//        head.right.left = new TreeNode(2);
        head.right.right = new TreeNode(7);
        TreeNode res = deleteNode(head, 3);
        System.out.println(res);
    }
}
