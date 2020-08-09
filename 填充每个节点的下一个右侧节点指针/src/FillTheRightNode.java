import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: 填充每个节点的下一个右侧节点指针
 * 给定一棵完美二叉树, 其所有叶子节点都在同一层, 每个父节点都有连个子节点
 * 填充它的每个 next 指针, 让这个指针指向其下一个右侧节点. 如果找不到下一个右侧节点, 则将 next 指针置为 null, 初始状态下, 所有的 next 指针都被置为 null
 *
 * 思路:
 * 1. 由于是让每一个节点的 next 指向下一个右侧节点, 如果找不到下一个右侧节点, 则将 next 指针置为 null
 *    可以看出, 这个操作是在同一层上进行的, 所以采用广度优先搜索的算法(层序遍历)
 * 2. 层序遍历需要借助队列来实现
 * 3. 需要使用一个变量 size 来记录每层节点的个数 (因为每一层最后一个节点的 next 为 null)
 * 4. 将队头元素出队, 只要队头元素不是最后一个元素, 就让它的 next 指向 队中的队首元素
 * 5. 如果出队的队头元素有左右孩子, 就让它的左右孩子分别进队
 * 进行递归
 *
 * User: HHH.Y
 * Date: 2020-08-09
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class FillTheRightNode {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        // root 不为空
        // 创建一个队列
        Queue<Node> queue = new LinkedList<>();
        // 将根节点进队
        queue.offer(root);
        while (!queue.isEmpty()) {
            // size 的值就是每一层节点的个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                // 当这个节点不是这层中最后一个节点时, 让这个节点的 next 指向 queue 中的队头节点
                if(i < size - 1) {
                    node.next = queue.peek();
                }
                // 如果这个节点有左右孩子, 就将它的左右孩子分别进队
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
