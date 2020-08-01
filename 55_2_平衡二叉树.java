/*  平衡二叉树：左右子树的深度差不超过1

    后序遍历，若不是平衡二叉树则剪枝，直接返回

    recur：
    1、 左右子树的差小于等于1 是平衡的 返回深度
    2、 大于1，返回-1
*/
public boolean isBalanced(TreeNode root) {
    return recur(root) != -1;
}

private int recur(TreeNode root){
    if(root==null)  return 0;
    int left=recur(root.left);
    if(left==-1)    return -1;  //剪枝，后面的不再进行，直接向上返回了
    int right=recur(root.right);
    if(right==-1)   return -1;  
    return Math.abs(left-right) <2 ? Math.max(left,right) +1 : -1;

}
