/**
 * Created with IntelliJ IDEA.
 * Description: 给定一棵二叉树, 检查它是否是镜像对称的
 *
 * 思路: 判断一棵二叉树是否是镜像对称二叉树
 * 一. 判断这棵树是否是对称树, 只有是对称树了之后才可以判断它是否是镜像树
 *      1. 如果根节点为空, 则该树也是对称树
 *      2. 如果根节点不为空
 *          ①. 判断左子树是否对称
 *          ②. 判断右子树是否对称
 *
 * 二. 判断左右子树是否是对称的
 *      1. 先判断左右子树的根节点值是否相同, 如果不同, 则说明不是对称的
 *      2. 如果根节点的值相同, 在判断是否是镜像的
 *          ①. 判断 左树的左 和 右树的右 是否相同
 *          ②. 判断 左树的右 和 右树的左 是否相同
 * User: HHH.Y
 * Date: 2020-08-07
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class IsSymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        // 如果根节点为空
        if(root == null) {
            return true;
        }
        // 如果根节点不为空, 需要判断其左右子树是否是对称的
        return isSymmetricChild(root.left, root.right);
    }

    // 判断左右子树是否是镜像对称的
    private boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        // 如果一个子树为空, 一个子树不为空, 则不是对称的
        if((leftTree == null && rightTree != null) || (leftTree != null && rightTree == null)) {
            return false;
        }
        // 如果左右两棵子树都为空, 就是镜像对称的
        if(leftTree == null && rightTree == null) {
            return true;
        }
        // 只有在左右子树的根节点值相同的时候, 才可以判断其是否是镜像对称的
        if(leftTree.val == rightTree.val) {
            return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
        }
        // 否则只有返回 false
        return false;
    }
}
