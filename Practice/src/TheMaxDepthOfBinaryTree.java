/**
 * Created with IntelliJ IDEA.
 * Description: 求二叉树的深度
 * User: HHH.Y
 * Date: 2020-09-01
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TheMaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 先找到左树的高度
        int left = maxDepth(root.left);
        // 再找到右树的高度
        int right = maxDepth(root.right);
        // 返回 1 + max(左树的高度, 右树的高度)
        return Math.max(left, right) + 1;
    }
}
