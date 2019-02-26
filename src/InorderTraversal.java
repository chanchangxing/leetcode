

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/2/26.
 */
public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();

        while (!nodeList.isEmpty() || root != null) {
            while (root != null) {
                nodeList.add(root);
                root = root.left;
            }

            root = nodeList.remove(nodeList.size() - 1);
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
//        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(2);

//        node.right = new TreeNode(5);
//        node.right.left = new TreeNode(6);
//        node.right.right = new TreeNode(7);

        System.out.println(inorderTraversal(node));
    }
}
