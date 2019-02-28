import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/2/28.
 */
public class BuildTree {
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        this.inorder = inorder;
        return a(0, 0, inorder.length);
    }

    public TreeNode a(int preIndex, int head, int end) {
        if (head + 1 == end) {
            return new TreeNode(preorder[preIndex]);
        } else if (head == end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex]);
        int rootIndex = 0;
        for (int inIndex = head; inIndex < end; inIndex++) {
            if (this.preorder[preIndex] == this.inorder[inIndex]) {
                rootIndex = inIndex;
                break;
            }
        }

        node.left = a(preIndex + 1, head, rootIndex);
        node.right = a(preIndex + rootIndex - head + 1, rootIndex + 1, end);

        return node;
    }

    static int index = 0;
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        return build(preorder,inorder,0,inorder.length - 1);
    }

    public static int serach(int [] inorder ,int str ,int end , int data){
        for ( int i = end ; i >= str ; i --){
            if ( inorder[i] == data){
                return i;
            }
        }
        return -1;
    }

    private static TreeNode build(int[] preorder,int[] inorder,int left,int right) {
        if (left > right || index >= preorder.length){
            return null;
        }
        int j = serach(inorder,left,right,preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        //buildleft
        index ++;
        node.left =build(preorder,inorder,left,j-1);
        //buildright
        node.right =build(preorder,inorder,j + 1,right);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = buildTree1(new int[]{4, 1, 2, 3}, new int[]{1, 2, 3, 4});
    }
}
