import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*  二叉树的广度优先一般都是用队列实现
    步骤：
    1.  当前节点的值加入到res
    2.  如果当前节点含有左右子节点，则加入左右子节点到队列中
*/

// Stack 用 pop 和 push ， Queue 用 poll offer ，List 都可以用 add
// Queue的add和remove在失败的时候会抛出异常。
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null)  return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();  //就是这样创建的 固定搭配了
        queue.add(root);
        ArrayList<Integer> ans=new ArrayList<>();  //因为不知道长度，所以先保存在ArrayList里
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            ans.add(node.val);
            if(node.left!=null)     queue.add(node.left);
            if(node.right!=null)    queue.add(node.right);
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i]=ans.get(i);  //get(i) 返回下标
        return res;
    }
}

//自己的练习 99.64 100
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null)  return new int[0];
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>(){{add(root);}};
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            ans.add(node.val);
            if(node.left!=null)     queue.offer(node.left);
            if(node.right!=null)    queue.offer(node.right);
        }

        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}