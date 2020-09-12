/**
 * Created with IntelliJ IDEA.
 * Description: 移除链表元素
 * User: HHH.Y
 * Date: 2020-09-09
 */
public class DeleteNode {
    public LNode removeElements(LNode head, int val) {
        if(head == null) {
            return null;
        }
        // 如果要删除的节点是头节点, 则直接将 head 往后移动
        if(head.val == val) {
            head = head.next;
            return head;
        }
        LNode prev = head;
        while (prev.next != null) {
            if(prev.next.val == val) {
                LNode cur = prev.next;
                prev.next = cur.next;
                return head;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
