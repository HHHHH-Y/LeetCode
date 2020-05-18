/**
 * Created with IntelliJ IDEA.
 * Description: 判断一棵树是否为镜像二叉树
 * 要判断一棵树是否为镜像二叉树, 需要如下步骤:
 * 1. 判断根节点是否为空, 若为空, 就不是镜像二叉树
 * 2. 否则,判断左子树是否是对称的
 * 3. 判断右子树是否是对称的
 *
 * 要判断左右子树是否对称, 需要如下步骤: (子问题的开始)
 * 1. 先判断左右子树的根
 * 2. 判断左右子树的根节点值是否相同
 * 3. 左右子树根节点值相同的时候, 判断左树的左和右树的右是否相同
 * 4. 判断左树的右和右树的左是否相同
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }

    public boolean isSymmetricChild (TreeNode leftTree, TreeNode rightTree) {
        if( (leftTree == null && rightTree != null) || (leftTree != null && rightTree == null) ) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree.val == rightTree.val) {
            return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
        }
        return false;
    }
}
