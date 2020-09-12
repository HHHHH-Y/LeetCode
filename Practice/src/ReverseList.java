/**
 * Created with IntelliJ IDEA.
 * Description: 反转一个单链表
 * User: HHH.Y
 * Date: 2020-09-09
 */
class LNode {
    int val;
    LNode next;
    public LNode(int val) {
        this.val = val;
    }
}
public class ReverseList {
    public LNode reverseList(LNode head) {
        LNode cur = head;
        LNode prev = null;
        LNode newHead = null;
        while (cur != null) {
            LNode curNext = cur.next;
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
