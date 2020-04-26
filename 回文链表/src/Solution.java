/**
 * Created with IntelliJ IDEA.
 * Description: 链表的回文结构
 * 给一个链表, 判断它是否是回文链表
 * 回文链表: 1->2->3->2->1
 * User: HHH.Y
 * Date: 2020-04-26
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // 如果单链表为空, 也是回文链表
        if(head == null) {
            return true;
        }
        // 如果单链表中只有一个节点, 那么一定是回文单链表
        if(head.next == null) {
            return true;
        }
        // 1. 找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow一定是中间节点
        // 2. 先将链表后半段进行反转
        ListNode cur = slow.next;
        ListNode prev = slow;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        // perv一定是最后一个节点
        while(head != prev) {
            // 3. 一个引用从前走, 一个从后走, 若两个节点对应的值不相同, 则一定不是回文链表
            // 两个节点每走一步都需要判断值是否相等
            if(head.val != prev.val) {
                return false;
            }
            // 4. 若链表为偶数个节点, 若从头走的节点的next是从尾走的节点, 说明链表是回文链表
            if(head.next == prev) {
                return true;
            }
            // 步进语句必须放在最后, 步进语句执行完之后就要判断两个节点的值是否还相同
            head = head.next;
            prev = prev.next;
        }
        // 5. 若节点对应的值相同, 若链表为奇数个节点, 两个节点相遇, 说明链表是回文链表
        return true;
    }
}
