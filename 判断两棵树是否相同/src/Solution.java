/**
 * Created with IntelliJ IDEA.
 * Description: 判断两棵树是否相同
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null && q != null || q == null && p != null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        // p.val = q.val
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
