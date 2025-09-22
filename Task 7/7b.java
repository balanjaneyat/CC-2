import java.util.ArrayList;
import java.util.List;

class TreeNodeB {
    int val;
    TreeNodeB left, right;
    TreeNodeB(int x) {
        val = x;
    }
}

public class CountPaths {
    public int countRootToLeafPaths(TreeNodeB root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countRootToLeafPaths(root.left) + countRootToLeafPaths(root.right);
    }
    public void printPaths(TreeNodeB root) {
        List<Integer> path = new ArrayList<>();
        printPathsHelper(root, path);
    }

    private void printPathsHelper(TreeNodeB node, List<Integer> path) {
        if (node == null) return;

        path.add(node.val);
        if (node.left == null && node.right == null) {
            System.out.println(path);
        } else {
            printPathsHelper(node.left, path);
            printPathsHelper(node.right, path);
        }
        path.remove(path.size() - 1);
    }
    public static void main(String[] args) {
        TreeNodeB root = new TreeNodeB(1);
        root.left = new TreeNodeB(2);
        root.right = new TreeNodeB(3);
        root.left.left = new TreeNodeB(4);
        root.left.right = new TreeNodeB(5);

        CountPaths cp = new CountPaths();
        System.out.println("Number of root-to-leaf paths: " + cp.countRootToLeafPaths(root));

        System.out.println("Root to leaf paths:");
        cp.printPaths(root);
    }
}
