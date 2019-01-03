import apple.laf.JRSUIUtils;

/**
 * Created by chenchangxing on 2019/1/3.
 */
public class SortedArrayToBST {
    TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return getTree(nums,0,nums.length - 1);
    }

    public TreeNode getTree(int []nums,int l,int r){
        if(l <= r){
            int mid = (l+r)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getTree(nums,l,mid-1);
            node.right = getTree(nums,mid+1,r);
            return node;
        }else{
            return null;
        }
    }

    static void show(TreeNode node) {
        if (node == null) {
            return;
        }

        show(node.left);
        System.out.println(node.val);
        show(node.right);
    }

    public static void main(String[] args) {
        show(new SortedArrayToBST().sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
