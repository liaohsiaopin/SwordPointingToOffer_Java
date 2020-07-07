/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //简单的思路：两次遍历，第一遍统计节点的个数，第二遍得到位置.
 //100 100
 class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        temp=head;
        int index=count-k+1;
        for(int i=1;i<index;i++){  //这里i从1开始，不是0。比如第1个节点是最终结果，它应该是一趟都走的。
            temp=temp.next;
        }
        return temp;
    }
}

//两个指针，一次遍历。两个指针之间的距离是k-1。当第二个指针指向链表结尾的时候，第一个指针的位置就是倒数第k个
//100 100
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode L1=head,L2=head;
        for(int i=0;i<k-1;i++)
            L2=L2.next;
        while(L2.next!=null){
            L1=L1.next;
            L2=L2.next;
        }
        return L1;
    }
}