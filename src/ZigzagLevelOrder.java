import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenchangxing on 2019/2/27.
 */
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<List<TreeNode>> nodeLists = new ArrayList<>();

        if (root == null) {
            return lists;
        }
        int index = 0;
        while (true) {
            boolean a = index % 2 == 0;
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            if (nodeLists.isEmpty()) {
                nodes.add(root);
                list.add(root.val);
                lists.add(list);
                nodeLists.add(nodes);
                index++;
                continue;
            }

            List<TreeNode> last = nodeLists.get(nodeLists.size() - 1);
            for (int i = last.size() - 1; i >= 0; i--) {
                if (!a) {
                    if (last.get(i).right != null) {
                        list.add(last.get(i).right.val);
                        nodes.add(last.get(i).right);
                    }

                    if (last.get(i).left != null) {
                        list.add(last.get(i).left.val);
                        nodes.add(last.get(i).left);
                    }
                } else {
                    if (last.get(i).left != null) {
                        list.add(last.get(i).left.val);
                        nodes.add(last.get(i).left);
                    }

                    if (last.get(i).right != null) {
                        list.add(last.get(i).right.val);
                        nodes.add(last.get(i).right);
                    }
                }
            }

            if (list.isEmpty()) {
                return lists;
            }

            lists.add(list);
            nodeLists.add(nodes);
            index++;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);

        node.right = new TreeNode(3);
//        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(5);

        List<List<Integer>> lists = zigzagLevelOrder(node);

        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
