import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: 使用队列来判断二叉树是否是完全二叉树
 * User: HHH.Y
 * Date: 2020-05-21
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
    // 判断一棵树是否是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return true; // 空树也是一棵完全二叉树
        }
        queue.offer(root); // 将根节点进队
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur1 = queue.peek();
            if(cur1 != null) {
                return false;
            }
            queue.poll();
        }
        return true;
    }
}
