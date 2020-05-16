import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 使用递归求解二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // root 为空
        if(root == null) {
            return list;
        }
        // root 不为空 中序遍历: 左 -> 根 -> 右
        List<Integer> left = inorderTraversal(root.left);
        list.addAll(left);
        list.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        list.addAll(right);
        return list;
    }
}
