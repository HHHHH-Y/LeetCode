/**
 * Created with IntelliJ IDEA.
 * Description: 输出链表的倒数第 k 个节点
 *
 * User: HHH.Y
 * Date: 2020-09-09
 */
public class FindKThToTail {
    public Node FindKthToTail(Node head,int k) {
        if(head == null) {
            return null;
        }
        Node cur = head;
        Node curNext = cur;
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
