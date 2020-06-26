
/**
 * Created with IntelliJ IDEA.
 * Description: 二叉平衡树的检查
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下
 * 对于树中的任意一个节点，其两棵子树的高度差不超过1
 * 给定指向树根节点的指针 TreeNode root, 请返回一个 bool, 代表这棵树是否平衡
 * User: HHH.Y
 * Date: 2020-06-26
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Balance {
    // 通过递归的方式计算一棵树的高度
    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left); // 递归左子树的高度
        int right = maxDepth(root.right); // 递归右子树的高度
        return Math.max(left, right) + 1; // 每次求出左右子树的最大高度 + 1 就是这棵树的高度
    }
    public boolean isBalance (TreeNode root) {
        if(root == null) {
            return true; // 空树也是一棵平衡二叉树
        }
        // 递归左树的高度
        int leftDepth = maxDepth(root.left);
        // 递归右树的高度
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
