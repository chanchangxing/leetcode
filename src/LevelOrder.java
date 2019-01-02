import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by chenchangxing on 2019/1/2.
 */
public class LevelOrder {

    private static Map<Integer, List<Integer>> map = new HashMap<>();

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        add(root, 1);

        lists.addAll(map.values());

        return lists;
    }

    static void add(TreeNode node, int index) {
        if (map.containsKey(index)) {
            map.get(index).add(node.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(index, list);
        }

        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left != null) {
            add(node.left, index + 1);
        }

        if (node.right != null) {
            add(node.right, index + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
//        node.right = new TreeNode(20);
//        node.right.left = new TreeNode(15);
//        node.right.right = new TreeNode(7);

        for (List<Integer> list :
                levelOrder(node)) {
            System.out.println(list.toString());
        }
    }
}
