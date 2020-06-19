/**
 * Created with IntelliJ IDEA.
 * Description: 镜像二叉树
 * 操作给定的二叉树， 将其变为原二叉树的镜像
 *
 * 思路：
 * 1. 先判断这棵树是否为空树
 * 2. 判断这棵树是否只有根节点
 * 3. 递归调换根节点的左右子树
 * User: HHH.Y
 * Date: 2020-06-19
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class MirrorBinaryTree {
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        // 交换根节点的两棵子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 如果左子树不为空，递归左子树
        if(root.left != null) {
            Mirror(root.left);
        }
        // 如果右子树不为空，递归右子树
        if(root.right != null) {
            Mirror(root.right);
        }
    }
}
