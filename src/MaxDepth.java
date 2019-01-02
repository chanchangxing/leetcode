/**
 * Created by chenchangxing on 2018/12/27.
 */
public class MaxDepth {
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return find(root.left, root.right, 1);
    }

    private static int ii = 0;
    static int find(TreeNode left, TreeNode right, int i) {
        System.out.println(ii++);
        if (left == null && right == null) {
            return i;
        }

        i++;
        int a = find(left == null ? null: left.left, left == null ? null: left.right, i);
        int b = find(right == null ? null: right.left, right == null ? null: right.right, i);

        return Math.max(a, b);
    }

    private static int iii = 0;
    static int maxDepth2(TreeNode root) {
        System.out.println(iii++);
        if (root == null) return 0;
        int lmax = maxDepth(root.left);
        int rmax = maxDepth(root.right);
        return 1 + Math.max(lmax, rmax);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(2);
//        node.right.left = new TreeNode(2);
//        node.right.left.right = new TreeNode(2);

        maxDepth(node);
        maxDepth2(node);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
