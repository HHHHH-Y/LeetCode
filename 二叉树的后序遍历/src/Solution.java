import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-16
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        List<Integer> left = postorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = postorderTraversal(root.right);
        list.addAll(right);
        list.add(root.val);
        return list;
    }
}
