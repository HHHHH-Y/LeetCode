/**
 * Created with IntelliJ IDEA.
 * Description: 二叉树的最近公共祖先
 * 给定一棵二叉树, 找出该树中两个指定节点的最近公共祖先
 *
 * 思路 (本题是求解最近公共祖先是哪一个节点)
 * 1. 如果树为空, 则返回空
 * 2. 如果树不为空, 且 p, q 两节点中, 只要有一个是根节点, 则最近公共祖先就一定是根节点
 * 3. 否则就分别遍历左子树和右子树, 得到节点值 left 和 right
 * 4. 如果 left 和 right 中都有值, 说明 p, q 分别位于左右子树中, 所以最近公共祖先一定是根节点
 * 5. 如果只有 left 中有值, 说明 p, q 都位于左子树中, 则最近公共祖先就是最先访问到的节点
 * 6. 同理, 如果只有 right 中有值, 说明 p, q 都位于右子树中, 则最近公共祖先就是最先访问到的节点
 * 7. 如果左右子树中都没有值, 则最近公共祖先就为 null
 * User: HHH.Y
 * Date: 2020-08-09
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class LeastCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为 null, 则返回 null
        if(root == null) {
            return null;
        }
        // 如果 p, q 中有一个是根节点, 那么最近公共祖先就是根节点
        if(root == p || root == q) {
            return root;
        }

        // 先遍历左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 再遍历右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树上各有一个节点, 说明最近公共祖先节点就是根节点
        if(left != null && right != null) {
            return root;
        }

        // 如果全部都在左子树上, 则最先遍历到的节点就是最近公共祖先节点
        if(left != null) {
            return left;
        }
        // 如果全都在右子树上, 则最先遍历到的节点就是最近公共祖先节点
        if(right != null) {
            return right;
        }
        // 如果左右子树上都没有, 则返回 null
        return null;
    }
}
