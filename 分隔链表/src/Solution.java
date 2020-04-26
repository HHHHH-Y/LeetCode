/**
 * Created with IntelliJ IDEA.
 * Description: 分隔链表
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 注意: 你应当保留两个分区中每个节点的初始相对位置
 * 例:  输入:  head = 1->4->3->2->5->2, x = 3
 *      输出:  1->2->2->4->3->5
 * User: HHH.Y
 * Date: 2020-04-26
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        while(head != null) {
            if(head.val < x) {
                // 如果是第一次插入
                if(bs == null) {
                    bs = head;
                    be = head;
                } else {
                    // 不是第一次插入
                    be.next = head;
                    be = be.next;
                }
            } else { // head.val >= x
                if(as == null) {
                    as = head;
                    ae = head;
                } else {
                    ae.next = head;
                    ae = ae.next;
                }
            }
            head = head.next;
        }
        // 1. 如果bs为空, 直接返回as
        if(bs == null) {
            return as;
        }
        // 2. 如果bs不为空, be.next = as
        be.next = as;
        // 3. 如果ae不为空, 那么ae.next需要置为空
        if(ae != null) {
            ae.next = null;
        }
        return bs;
    }
}
