class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class LongestUnivaluePath {
    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return maxLength;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        int leftPath = 0, rightPath = 0;
        if (node.left != null && node.left.val == node.val) {
            leftPath = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightPath = right + 1;
        }

        maxLength = Math.max(maxLength, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        LongestUnivaluePath sol = new LongestUnivaluePath();
        System.out.println("Longest Univalue Path length: " + sol.longestUnivaluePath(root)); // Output should be 2
    }
}
