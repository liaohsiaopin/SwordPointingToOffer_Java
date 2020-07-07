/*  需要i j k三个节点，才能保证链表正常反转
    考虑三种输入：1.空链表 2.一个节点链表 3.多个节点链表
*/

// 两个指针 100 100
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=null, pre=head,t;
        while(pre!=null){
            t=pre.next;
            pre.next=cur;
            cur=pre;
            pre=t;
        }
        return cur;
    }
}

// 递归  100 100
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode ret=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return ret;
    }
}

// 另一种双指针
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        ListNode cur=head;
        while(head.next!=null){
            ListNode t=head.next;
            head.next.next=cur;
            cur=head.next;
            head.next=t;
        }
    }
}