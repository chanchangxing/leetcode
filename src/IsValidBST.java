/**
 * Created by chenchangxing on 2018/12/28.
 */
public class IsValidBST {
    static Integer last = null;
    static boolean isValidBST(TreeNode root) {
        if (root != null) {
            boolean a = isValidBST(root.left);
            if (last != null && last >= root.val) {
                return false;
            }
            last = root.val;
            System.out.println(last);
            boolean b = isValidBST(root.right);
            return a && b;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(1);
//        root.right.left.right.right = new TreeNode(25);

        System.out.println(isValidBST(root));
    }
}
