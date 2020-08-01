/*  思路：
    判断每对节点是否对称，从而判断是否为对称二叉树

    算法流程：
    1.  isSymmetric：若根节点为空，则返回true。 返回值：rerure（root.left,root.right）
    2.  recur(): L和R同时越过叶节点，表明从顶到底都对称。只有一个越过，不对称，值不相等，不对称
            递推工作：recur(L.left,R.right) recue(L.right,R.left)
    
    时间复杂度：每次recur可以判断一对节点，N/2  空间复杂度：二叉树退化为链表，是ON的栈空间
    100 100
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null? true: recur(root.left,root.right);
    }

    boolean recur(TreeNode L,TreeNode R){
        if(L==null && R==null)   return true;
        if(L==null || R==null || R.val!=L.val)  return false;
        return recur(L.left,R.right) && recur(L.right,R.left);
    }
}

    