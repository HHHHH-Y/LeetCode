/**
 * Created with IntelliJ IDEA.
 * Description: 找到两个单链表相交的起始节点
 * User: HHH.Y
 * Date: 2020-04-27
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curL = headA; // 先默认较长的单链表为A
        ListNode curS = headB; // 默认较短的单链表为B
        // 1. 计算出两个单链表的长度lenA, lenB
        ListNode cur = headA;
        int lenA = 0;
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        int lenB = 0;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }
        // 2. 求两个单链表的长度 len = lenA - lenB
        int len = lenA - lenB;
        // 3. 如果len < 0, 说明lenA < lenB, 改变curL和curS的指向, 然后更新len
        if(len < 0) {
            curL = headB;
            curS = headA;
            len = lenB - lenA;
        }
        // 4. 让curL先走len步, 然后curL和curS一起走, 直到走到相交的起始节点处
        while(len != 0) {
            curL = curL.next;
            len--;
        }
        while(curL != null && curS != null && curL != curS) {
            curL = curL.next;
            curS = curS.next;
        }
        if(curL == curS && curL != null) {
            return curL;
        }
        return null;
    }
}
