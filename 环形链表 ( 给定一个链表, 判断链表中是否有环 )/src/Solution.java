/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个链表, 判断链表中是否有环
 * User: HHH.Y
 * Date: 2020-04-25
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 1. 定义两个引用, 一个走一步, 一个走路两步
        ListNode fast = head;
        ListNode slow = head;
        // 2. 如果单链表中存在 null, 说明该单链表一定没有环
        // 3. 若这两个引用相遇, 则说明这个单链表一定有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
