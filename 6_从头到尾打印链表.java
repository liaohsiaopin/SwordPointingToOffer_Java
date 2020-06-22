/*  思路1：栈 or 递归
    递归看起来简洁，但如果链表非常长导致代码调用深 可能出现栈溢出 
*/

/*  思路2：反转链表后打印
    问题；打印一般不修改数据
*/

/*  其他知识
    鲁棒性：Robust，健壮和强壮 
*/

 // 栈   49.29%  100%
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>(); //是Integer不是int
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        int size=stack.size();
        int[] res=new int[size];
        for(int i=0;i<size;i++){
            res[i]=stack.pop();
        }
        return res;      
    }
}

// 一遍扫描获取长度 二遍扫描完成数组倒叙存储  100 100
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode cur=head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        cur=head;
        int[] res=new int[size];
        while(cur!=null){
            res[size-1]=cur.val;
            size--;
            cur=cur.next;
        }     
        return res;
    }
}