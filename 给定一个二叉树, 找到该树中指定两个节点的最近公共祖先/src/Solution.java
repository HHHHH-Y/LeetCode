/**
 * Created with IntelliJ IDEA.
 * Description: 给定一棵二叉树, 找到该树中指定两个节点的最近公共祖先
 * 如果 p 或者 q 就是根节点, 那么直接返回根节点即可
 * 如果 p q 位于根节点的左右子树上, 最近公共祖先就是根节点
 * 如果 p q 都位于左子树上, 最近公共祖先就是最先访问到的节点
 * 如果 p q 都位于右子树上, 最近公共祖先就是最先访问到的节点
 * User: HHH.Y
 * Date: 2020-05-19
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        // 如果 P 或者 q 就是根节点, 最近公共祖先就是根节点
        if(root == p || root == q) {
            return root;
        }
        // 访问左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 访问右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            // 如果 p 和 q 分别在根节点的左右两棵子树上, 那么最近公共祖先节点就是根节点
            return root;
        } else if(left != null) {
            // 如果 p 和 q 都在左子树上, 那么最近的公共祖先就是最先访问的节点
            return left;
        } else if(right != null) {
            // 如果 p 和 q 都在右子树上, 那么最近的公共祖先就是最先访问的节点
            return right;
        } else {
            // 如果左右子树上都没有 p 和 q, 就返回null
            return null;
        }
    }
}
