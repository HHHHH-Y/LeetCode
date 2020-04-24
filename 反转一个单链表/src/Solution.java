/**
 * Created with IntelliJ IDEA.
 * Description: 反转一个单链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 * User: HHH.Y
 * Date: 2020-04-24
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseList(ListNode head) {
        // 1. 定义一个cur, prev, curNext, 分别表示当前需要反转的节点, 上一个节点, 下一个需要反转的节点
        // 2. 然后依次进行反转, 直到curNext==null的时候, 代表着cur刚好到了最后一个节点处, 然后标记其为newHead
        // 3. 继续反转最后一个节点, 直到将所有节点都反转完成之后, 返回newHead
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode cueNext = cur.next; // 只有cur不等于空的时候, 才会有curNext, 否则, 就会出现空指针异常
            if(cueNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = cueNext;
        }
        return newHead;
    }
}
