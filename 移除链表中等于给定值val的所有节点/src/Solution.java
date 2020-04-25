/**
 * Created with IntelliJ IDEA.
 * Description:移除链表中等于给定值 val 的所有节点
 * User: HHH.Y
 * Date: 2020-04-25
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 1. 删除 除了头节点以外的所有值为key的节点
        if(head == null) {
            return null;
        }
        ListNode prev = head; // 代表要删除节点的前驱节点
        ListNode cur = head.next; // 代表要删除的节点
        while (cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        // 2. 判断头节点是否为key, 若是, 就删掉头节点
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }
}
