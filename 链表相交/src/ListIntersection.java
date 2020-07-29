

/**
 * Created with IntelliJ IDEA.
 * Description: 链表相交
 * 给定两个(单向)链表, 判定他们是否相交并返回交点.
 * 请注意相交的定义基于节点的引用, 而不是基于节点的值. 换句话说, 如果一个链表的第 k 个节点与另一个链表的第 j 个节点是同一节点(引用完全相同), 则这两个链表相交
 *
 * 思路:
 * 1. 先默认较长的单链表是 A, 较短的单链表是 B, 并定义两个节点 curL 和 curS, 分别指向 A 和 B
 * 2. 计算出两个单链表的长度 lenA 和 lenB
 * 3. 计算出长度差 len = lenA - lenB
 * 4. 如果长度差 len < 0, 说明 lenA < lenB, 则需要修改 curL 和 curS 的指向, 并更新 len
 * 5. 让 curL 先走 len 步, 然后 curL 和 curS 一起走, 直到走到相交的节点即可
 *
 * 注意:
 * 1. 一起走的时候一定要判断 curL 是否为 null, curS 是否为 null
 * 2. 当 curL == curS 的时候, 还需要判断他们是否为 null, 如果不为 null, 才说明他们指向了相交的节点
 *    如果 curL = curS && curL == null 的时候, 说明最少有一个链表已经遍历完了, 则两个单链表不想交, 返回结果为 null
 * User: HHH.Y
 * Date: 2020-07-28
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curL = headA; // 先默认较长的单链表是 A
        ListNode curS = headB; // 先默认较短的单链表是 B
        // 1. 分别计算两个单链表的长度 lenA 和 lenB
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

        // 2. 计算出两个链表的长度差 len = lenA - lenB
        int len = lenA - lenB;
        if(len < 0) {
            // 说明 lenA < lenB, 那么需要更改 curL 和 curS 的指向, 并更新 len
            curL = headB;
            curS = headA;
            len = lenB - lenA;
        }

        // 3. 先让 curL 走 len 步
        for (int i = 0; i < len; i++) {
            curL = curL.next;
        }

        // 4. curL 和 curS 一起走, 直到走到相交的节点为止
        while (curL != null && curS != null && curL != curS) {
            curL = curL.next;
            curS = curS.next;
        }
        if(curL == curS && curL != null) {
            return curL;
        }
        return null;
    }
}
