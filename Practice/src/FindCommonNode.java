/**
 * Created with IntelliJ IDEA.
 * Description: 相交链表
 * User: HHH.Y
 * Date: 2020-09-10
 */
public class FindCommonNode {
    public LNode getIntersectionNode(LNode headA, LNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        LNode curL = headA;
        LNode curS = headB;
        int lenA = 0;
        LNode cur = headA;
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
        int len = lenA - lenB;
        if(len < 0) {
            curL = headB;
            curS = headA;
            len = lenB - lenA;
        }
        for (int i = 0; i < len; i++) {
            curL = curL.next;
        }
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
