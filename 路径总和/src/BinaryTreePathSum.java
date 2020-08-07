/**
 * Created with IntelliJ IDEA.
 * Description: 路径总和
 * 给定一个二叉树和一个目标和, 判断该树中是否存在根节点到叶子节点的路径, 这条路径上所有的节点值相加等于目标和
 *
 * 思路:
 * 1. 如果树为空, 则返回 false
 * 2. 如果树不为空, 则进行递归.
 *    每遍历一个节点, 就让 sum - 该节点的值, 直到叶子节点. 如果叶子节点的值刚好等于 sum, 则说明有这样的分支存在
 * 3. 先遍历左子树, 再遍历右子树]
 * 4. 将这两个结果取 或 并返回 (只要有一个结果为 true, 就说明存在这样的分支)
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

public class BinaryTreePathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 如果树为空, 则返回 false
        if(root == null) {
            return false;
        }
        // 如果叶子节点的值刚好等于 sum 值, 就返回 true (递归的出口)
        if(root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        // 先遍历左子树
        boolean left = hasPathSum(root.left, sum - root.val);
        // 再遍历右子树
        boolean right = hasPathSum(root.right, sum - root.val);
        // 将结果 或 一下, 因为只要有一个结果为 true, 说明就有这样的分支存在, 结果就为 true
        return left || right;
    }
}
