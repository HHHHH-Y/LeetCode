/**
 * Created with IntelliJ IDEA.
 * Description: 求二叉树的最大深度
 * 二叉树的深度 = max( (左树的高度 + 1), (右树的高度 + 1) )
 * User: HHH.Y
 * Date: 2020-05-18
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
