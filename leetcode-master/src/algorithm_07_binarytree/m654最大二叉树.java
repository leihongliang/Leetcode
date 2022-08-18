package algorithm_07_binarytree;

public class m654最大二叉树 {
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
    public static TreeNode  constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }
    public static TreeNode helper(int[] nums, int left, int right) {
        if(left > right) return null;
        if(left == right) return new TreeNode(left);
        int max = nums[left];
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, left, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, nums.length - 1);
        return root;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode res = constructMaximumBinaryTree(nums);
        System.out.println(res);
    }
}
