import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: 二叉树的层序遍历
 * 题目要求:
 * 最后遍历得到的集合 应该是每一层遍历集合 的总集合
 *
 * 思路:
 * 创建一个 队列 Queue, 用于层序遍历
 * 首先判断这棵二叉树是否为空, 如果为空, 返回一个空集合
 * 如果不为空:
 * 1. 先将头节点放进队列中
 * 2. 在队列 queue 不为空的情况下
 *      ①. 先计算出队列的长度 size, 这个长度就是每一层节点的个数
 *      ②. 计算出 size 后, 就创建一个 list 集合, 用于存放这一层的所有节点
 *      ③. 先出队 队首元素, 如果队首元素不为空, 则放入队列中, 然后分别判断它的左右孩子, 如果存在, 就放入队列中
 *      ④. 每出队一个元素, size--, 直到 size = 0 时, 说明该层节点全部出队
 *      ⑤. 将 list 集合加入到 levelList 集合中
 * 3. 当队列为空, 说明遍历结束, 返回 levelList 即可
 * User: HHH.Y
 * Date: 2020-08-06
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class LevelTreeOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>(); // 用于存放 每一层集合 的集合
        Queue<TreeNode> queue = new LinkedList<>(); // 创建一个队列, 用于进行层次遍历
        if(root == null) {
            return levelList;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 队列的长度 size 就是每一层节点的个数
            List<Integer> list = new ArrayList<>(); // 计算出 size 后, 就可以创建一个集合, 用于存放每层的节点
            while (size > 0) {
                TreeNode node = queue.poll();
                if(node != null) {
                    list.add(node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                size--;
            }
            // 将每一层节点的集合 存放到 大的集合中
            levelList.add(list);
        }
        return levelList;
    }
}
