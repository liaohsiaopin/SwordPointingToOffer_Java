import java.util.ArrayList;

/*  两道题的区别：  每一层打印到一行
*/
// 93.58 100
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>(); //List也是new ArrayList<>()
        if(root!=null)  queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp=new ArrayList<>(); //一个也是ArrayList
            for(int i=queue.size();i>0;i--){  //queue.size()是动态变化的 所以初始值是queue.size
                TreeNode node=queue.poll();
                tmp.add(node.val);
                if(node.left!=null)     queue.offer(node.left);
                if(node.right!=null)    queue.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}