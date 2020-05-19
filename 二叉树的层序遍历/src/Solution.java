import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树的层序遍历
 * 借助队列来完成
 *
 * 每遍历一层, 就将它放进一个队列中, 然后将这个队列放在一个大的队列中.
 * User: HHH.Y
 * Date: 2020-05-19
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 创建一个集合, 用于存放每层的集合
        List<List<Integer>> ret = new ArrayList<>();
        // 创建一个队列, 用于进行层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return ret;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 计算队列的长度, 就相当于是计算出了每层的节点个数
            int size = queue.size();
            // 计算出一层的节点个数后, 就创建一个对应的集合, 用于存放该层的节点
            List<Integer> list = new LinkedList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                if(cur != null) {
                    list.add(cur.val);
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                size--;
            }
            // 当一层的节点全部放入到对应集合中后, 将该集合加入到大集合中
            ret.add(list);
        }
        return ret;
    }
}
