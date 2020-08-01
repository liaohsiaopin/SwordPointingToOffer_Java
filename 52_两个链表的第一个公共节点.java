/**
\   思路：  两个链表的长度是L1+C和L2+C，当两个指针都走了L1+L2+C的时候就会相遇
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)    return null;    
        ListNode L1=headA,L2=headB;
        while(L1!=L2){
            L1= L1==null? headB: L1.next;
            L2= L2==null? headA: L2.next;
        }
        return L1;
    }
}