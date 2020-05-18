/**
 * Created with IntelliJ IDEA.
 * Description: 给定一棵二叉树, 判断它是否是一棵高度平衡的二叉树
 * 一个二叉树 每个节点 的左右两个子树的高度差的 绝对值 不超过1。
 * User: HHH.Y
 * Date: 2020-05-18
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) <= 1) {
            return isBalanced(root) && isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

}
