/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-27
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

}
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null && t2 != null) {
            return t2;
        } else if(t1 != null && t2 == null){
            return t1;
        }
        // 两棵子树都不为空
        TreeNode ret = new TreeNode(-1);
        ret.val = t1.val + t2.val;
        ret.left = mergeTrees(t1.left, t2.left);
        ret.right = mergeTrees(t1.right, t2.right);
        return ret;
    }
}
