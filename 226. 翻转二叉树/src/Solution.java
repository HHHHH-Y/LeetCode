/**
 * Created with IntelliJ IDEA.
 * Description: 翻转一棵二叉树
 * 思路:
 * 1. 如果根节点为空, 直接返回 null
 * 2. 如果只有根节点, 没有左右子树, 就返回根节点
 * 3. 如果根节点, 左右子树都存在, 就交换左右子树
 * 4. 递归左子树和右子树
 * User: HHH.Y
 * Date: 2020-07-06
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        TreeNode cur = root;
        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;
        if(cur.left != null) {
            TreeNode left = invertTree(cur.left);
        }
        if(cur.right != null) {
            TreeNode right = invertTree(cur.right);
        }
        return root;
    }
}
