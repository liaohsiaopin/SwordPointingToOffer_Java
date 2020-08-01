/*  二叉搜索树的中序遍历是顺序的，逆序是倒序的
    中序遍历的倒序的第k个就是结果了，即使用右中左的顺序即可
*/
class Solution {
    int res,k;

    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if(root==null || k==0)  return;
        dfs(root.right);
        if(--k==0)  {
            res=root.val;
            return ;
        }
        dfs(root.left);
    }
}