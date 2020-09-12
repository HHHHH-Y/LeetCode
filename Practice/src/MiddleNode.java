/**
 * Created with IntelliJ IDEA.
 * Description: 查找链表的中间节点
 * User: HHH.Y
 * Date: 2020-09-09
 */
public class MiddleNode {
    public LNode middleNode(LNode head) {
        if(head == null) {
            return null;
        }
        LNode fast = head;
        LNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
