/**
 * Created with IntelliJ IDEA.
 * Description: 反转链表
 * 定义一个函数, 输入链表的头结点, 反转该链表, 并输出反转后链表的头结点
 *
 * 输入: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * 输出: 5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * 思路:
 * 整体反转单链表, 就应该对每个节点分别进行反转
 * 1. 定义一个 cur, preCur, curNext, 分别表示当前要反转的节点, 反转节点的前一个节点, 下一个要反转的节点
 *    (注意: 由于 curNext 表示下一个需要反转的节点, 所以只有当 当前节点不为空的时候, 才会存在下一个要反转的节点, 否则可能会出现空指针异常)
 * 2. 然后对每个节点进行反转
 * 3. 当翻转到最后一个节点的时候, 需要进行标记, 然后再将最后一个节点也进行反转
 * 4. 返回标记的节点即可
 *
 * User: HHH.Y
 * Date: 2020-07-27
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode preCur = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next; // 只有 cur 不为空的时候, curNext 才存在
            if(curNext == null) {
                // 此时说明 cur 就为最后一个节点
                newHead = cur;
            }
            cur.next = preCur;
            preCur = cur;
            cur = curNext;
        }
        return newHead;
    }
}
