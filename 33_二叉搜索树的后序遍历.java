/*  思路一：分治，如果每个子树都是搜索二叉树，那就是二叉排序树
    1.  遍历后序遍历的[i,j]区间，寻找第一个大于根节点的节点，索引记m，可以划分左子树区间[i,m-1],右[m,j-1],根j
    2.  判断是否为二叉搜索树：
        1.  左子树区间的[i,m-1]都应该小于根节点，这个是成立的，因此只需要判断右子树
        2.  右子树区间[m,j]的节点都大于根节点
        3.  结束条件，i>=j 说明子树节点数量<=1，无需判别正确性，返回true
    3.  返回值：
        1.  p=j 判断此树是否正确
        2.  recur(i,m-1)    左子树
        3.  recur(m,j)      右子树
*/
// 100 100
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    boolean recur(int[] postorder, int i, int j){
        if(i>=j)    return true;
        int p=i;
        while(postorder[p]<postorder[j]) p++;
        int m=p;
        while(postorder[p]>postorder[j]) p++;
        return p==j && recur(postorder, i, m-1) && recur(postorder, m, j-1); // 只有p==j 才能return true，否则是有问题的
    }
}