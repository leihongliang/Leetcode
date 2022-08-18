package algorithm_07_binarytree;

import java.util.*;

public class e257二叉树的所有路径 {
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

    public static List<String> binaryTreePaths1(TreeNode root) {
        Queue<TreeNode> node = new LinkedList<>();
        Queue<String> path = new LinkedList<>();
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        node.offer(root);
        //path.push(root.val + "");
        path.offer(root.val + "");
        while (!node.isEmpty()) {
            TreeNode tmpNode = node.poll();
            String tmpPath = path.poll();
            if (tmpNode.left == null && tmpNode.right == null) {
                res.add(tmpPath);
            }
            if (tmpNode.left != null) {
                node.offer(tmpNode.left);
//                path.offer(tmpPath + "->" + tmpNode.left.val);
                path.offer(new StringBuffer(tmpPath).append("->").append(tmpNode.left.val).toString() );
            }
            if (tmpNode.right != null) {
                node.offer(tmpNode.right);
//                path.offer(tmpPath + "->" + tmpNode.right.val);
                path.offer(new StringBuffer(tmpPath).append("->").append(tmpNode.right.val).toString() );
            }
        }
        return res;
    }

    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private static void traversal2(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        // 叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        if (root == null) return res;
        traversal(root, paths, res);
        return res;

    }
    private static void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            res.add(sb.toString());
            return;
        }
        if (root.left != null) traversal(root.left, paths, res);
        if (root.right != null) traversal(root.right, paths, res);
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);
        List res = binaryTreePaths(head);
        System.out.println(res);
    }
}

