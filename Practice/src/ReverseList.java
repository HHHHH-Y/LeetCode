/**
 * Created with IntelliJ IDEA.
 * Description: 反转一个单链表
 * User: HHH.Y
 * Date: 2020-09-09
 */
class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}
public class ReverseList {
    public Node reverseList(Node head) {
        Node cur = head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
