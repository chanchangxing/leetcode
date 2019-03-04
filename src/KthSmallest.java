import apple.laf.JRSUIUtils;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/4.
 */
public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        TreeNode process = root;
        List<TreeNode> list = new ArrayList<>();
        a(process, list);
        return list.get(k).val;
    }

    public static void a(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        a(node.left, list);
        list.add(node);
        a(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(4);

        kthSmallest(node, 1);
    }

}
