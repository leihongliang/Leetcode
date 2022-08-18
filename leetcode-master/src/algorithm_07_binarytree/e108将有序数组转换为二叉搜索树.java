package algorithm_07_binarytree;

public class e108将有序数组转换为二叉搜索树 {
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
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    public static TreeNode helper (int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid -1);
        root.right = helper(nums, mid + 1, right);
        return root;


    }
    public static void main(String[] args) {
        int num[] = {1,2,3,4,5};
        TreeNode res = sortedArrayToBST(num);
        System.out.println(res);
    }
}
