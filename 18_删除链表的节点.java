/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //删除指定节点，且节点在链表中。（确保节点在链表中的这个东西靠函数调用者实现）
 //这道题LeetCode中的是链表的val(O(n))，但是书中是链表的具体位置((O(1)))。
 // 100 100
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) return head;
        if(head.val==val) return head.next;
        ListNode cur=head;
        while(cur.next!=null&&cur.next.val!=val){
            cur=cur.next;
        }
        if(cur.next!=null){
            cur.next=cur.next.next;
        }
        return head;
    }
}