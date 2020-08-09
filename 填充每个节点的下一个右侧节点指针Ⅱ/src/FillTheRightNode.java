import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: 填充每个节点的下一个右侧节点指针Ⅱ
 * 给定一个二叉树, 填充它的每个 next 指针, 让这个指针指向其下一个右侧节点. 如果找不到下一个右侧节点, 则将 next 指针置为 null. 初始状态下, 所有 next 指针都被设置为 null
 *
 * 思路:
 * 同 填充每个节点的下一个右侧节点指针 一样
 * 使用层序遍历的方式, 借助队列来实现
 * 记录下每一层节点的个数
 * 只要不是最后一个节点, 就让出队的节点的 next 等于队头节点
 * 如果这个节点有左右孩子, 就将这个节点的左右孩子加入到队列中
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
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i < size - 1) {
                    node.next = queue.peek();
                }
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
