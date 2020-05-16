import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // root为空
        if(root == null) {
            return list;
        }
        // root不为空, 采用前序遍历的方式进行遍历
        list.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        list.addAll(right);
        return list;
    }
}
