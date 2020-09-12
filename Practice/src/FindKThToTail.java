/**
 * Created with IntelliJ IDEA.
 * Description: 输出链表的倒数第 k 个节点
 *
 * User: HHH.Y
 * Date: 2020-09-09
 */
public class FindKThToTail {
    public LNode FindKthToTail(LNode head, int k) {
        if(head == null) {
            return null;
        }
        LNode cur = head;
        LNode curNext = cur;
        for (int i = 0; i < k - 1; i++) {
            curNext = curNext.next;
        }
        while (curNext.next != null) {
            cur = cur.next;
            curNext = curNext.next;
        }
        return cur;
    }
}
