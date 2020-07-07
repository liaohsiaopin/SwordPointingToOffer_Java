/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 建立一个头结点，然后依次往后比较  99.33 100
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead=new ListNode(0);
        ListNode cur=newHead;
        while(l1!=null&& l2!=null){ //不能用l1&&l2
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next= l1!=null?l1:l2;
        return newHead.next;
}
}

// 递归 99.33 100
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){   
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }   
}
}