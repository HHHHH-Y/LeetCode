/**
 * Created with IntelliJ IDEA.
 * Description:
 *  给定两个非空二叉树 s 和 t，
 *  检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 *  s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 *  s 也可以看做它自身的一棵子树。
 * User: HHH.Y
 * Date: 2020-05-18
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    // 判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        // 判断t树是否为s这棵树的本身
        if (isSameTree(s, t)) {
            return true;
        }
        // 判断t是否为s左树的子树
        // 判断t是否为s右树的子树
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

}
