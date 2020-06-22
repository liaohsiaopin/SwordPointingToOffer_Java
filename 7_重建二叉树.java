// 有递归和迭代的方法

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*  递归
    思路：   前序遍历中创建根节点，中序遍历找到左右子树的左右边界和前序遍历中根节点的位置
            判断无法创建的条件：左边界>右边界
            构建HashMap快速找到中序遍历中根节点的位置
            全局变量保存前序遍历
    结果：   81.67 100
*/
class Solution {
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    int[] preorder2;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }

        //构建HashMap
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        //传递到全局变量
        preorder2=preorder;

        //调用
        return recur(0,0,inorder.length-1);
    }

    /*
        preRootIndex ：前序遍历中根节点的位置
        inLeft：       中序遍历中的左边界
        inRight：      中序遍历中的右边界
    */
    public TreeNode recur(int preRootIndex,int inLeft,int inRight){
        if(inLeft>inRight){
            return null;
        }
        TreeNode root=new TreeNode(preorder2[preRootIndex]); //创建根节点
        int inRootIndex=map.get(preorder2[preRootIndex]); //中序遍历中根节点的位置
        root.left=recur(preRootIndex+1,inLeft,inRootIndex-1);
        root.right=recur(preRootIndex+(inRootIndex-inLeft+1),inRootIndex+1,inRight);//括号中是左子树的长度
        return root;
    }
}