/**
 * Created with IntelliJ IDEA.
 * Description: 给定一棵二叉树, 判断它是否是高度平衡二叉树
 *
 * 1. 计算出树的高度
 * 2. 分别计算出左树的高度和右树的高度, 只要高度差不超过1, 就是平衡树, 否则不是平衡树
 * User: HHH.Y
 * Date: 2020-09-03
 */
class TreesNode {
    int val;
    TreesNode left;
    TreesNode right;

    public TreesNode(int val) {
        this.val = val;
    }
}
public class BalanceBinaryTree {
    public int maxDepth(TreesNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
    public boolean isBalanced(TreesNode root) {
        if(root == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
}
