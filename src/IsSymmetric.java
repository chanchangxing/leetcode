import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by chenchangxing on 2018/12/29.
 */
public class IsSymmetric {
    static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compare(root.left, root.right);
    }

    static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;

        boolean a = compare(left.left, right.right);
        boolean b = compare(left.right, right.left);

        return a && b;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);

        node.right = new TreeNode(2);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);

        System.out.println(isSymmetric(node));
    }
}
