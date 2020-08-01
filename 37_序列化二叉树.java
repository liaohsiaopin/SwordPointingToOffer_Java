import java.util.Queue;

import javax.management.Query;
import javax.swing.tree.TreeNode;

/*  观察，序列化的二叉树是层次遍历。序列化和反序列化是互相可逆的，因此要保存二叉树的完整结构
    为了保证反序列化，考虑将叶子结点的左右null子节点也看做节点，因此层次遍历的时候其序列化都是唯一确定了。

    反序列化：
    用队列按层构建二叉树，借助指针i指向node的左、右节点，每构建一个节点node就右移一次

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)  return "[]";
        StringBuilder res=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                res.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]"))      return null;
        String[] vals
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));