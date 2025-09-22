import java.util.*;

class TreeNodeC {
    int val;
    TreeNodeC left, right;
    TreeNodeC(int x) {
        val = x;
    }
}

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNodeC root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNodeC> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNodeC node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNodeC root = new TreeNodeC(1);
        root.left = new TreeNodeC(2);
        root.right = new TreeNodeC(3);
        root.left.left = new TreeNodeC(4);
        root.left.right = new TreeNodeC(5);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        List<List<Integer>> levels = lot.levelOrder(root);
        System.out.println("Level order traversal:");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
