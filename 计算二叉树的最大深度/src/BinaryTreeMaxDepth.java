/**
 * Created with IntelliJ IDEA.
 * Description: 求二叉树的最大深度
 * 给定一个二叉树, 找出其最大深度
 * 二叉树的深度: 根节点到最远叶子节点的最长路径的节点数
 *
 * 思路: 使用递归的方式, 先求根节点左右子树的深度, 然后找出最大的深度值, 加一就可以得到该二叉树的深度了
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
public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 如果是叶子节点(找到递归的出口)
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max + 1;
    }
}
