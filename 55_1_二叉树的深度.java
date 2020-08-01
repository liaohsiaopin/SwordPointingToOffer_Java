/*  思路一：后序遍历
    树的深度是左子树/右子树的深度的最大值+1
*/

//好简洁啊我的天哪！
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

/*  思路二：层次遍历
    每遍历一层，计数器加一
*/

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        List<TreeNode> queue=new LinkedList<>(),tmp;

        queue.add(root);
        int res=0;
        while(!queue.isEmpty()){
            tmp=new LinkedList<>();
            for(TreeNode node:queue){
                if(node.left!=null)  tmp.add(node.left);
                if(node.right!=null)   tmp.add(node.right);
            }
            queue=tmp;
            res++;  
        }
        return res;
    }
}