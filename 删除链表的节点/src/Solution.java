/**
 * Created with IntelliJ IDEA.
 * Description: 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 * 题目保证链表中节点的值互不相同
 * User: HHH.Y
 * Date: 2020-04-24
 */

/**
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if(head.val == val) {
            head = head.next;
            return head;
        }
        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.val == val) {
                ListNode del = prev.next;
                prev.next = del.next;
                return head;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
