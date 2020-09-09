/**
 * Created with IntelliJ IDEA.
 * Description: 移除链表元素
 * User: HHH.Y
 * Date: 2020-09-09
 */
public class DeleteNode {
    public Node removeElements(Node head, int val) {
        if(head == null) {
            return null;
        }
        Node node = new Node(-1);
        node.next = head;
        Node prev = node;
        Node cur = head;
        while (cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return node.next;
    }
}
