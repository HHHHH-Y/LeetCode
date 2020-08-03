/**
 * Created with IntelliJ IDEA.
 * Description: 移除链表元素
 * 删除链表中等于给定值 val 的所有节点
 * 输入: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
 * 输出: 1 -> 2 -> 3 -> 4 -> 5
 *
 * 思路: 1. 先删除掉 除头节点以外的所有值为 val 的节点
 *       2. 再判断头节点的值是否为 val, 如果是, 则删除头节点
 * User: HHH.Y
 * Date: 2020-08-03
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class RemoveSameNode {
    public ListNode removeElements(ListNode head, int val) {
        // 1. 判断链表是否为空
        if(head == null) {
            return null;
        }
        // 2. 删除 除头节点以外的所有值为 val 的节点
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if(prev == null) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        // 3. 判断头节点的值是否为 val
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }
}
