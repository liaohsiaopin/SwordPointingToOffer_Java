import java.util.LinkedList;

/*  LinkedList 有addFirst和addLast
*/
// 99.79 100
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null)  queue.offer(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> temp=new LinkedList<>();
            for(int i=queue.size();i>0;i--){  //倒数是因为queue.size是变化的
                TreeNode node=queue.poll();
                if(res.size()%2==0) temp.addLast(node.val);  //顺序
                else temp.addFirst(node.val);   //逆序
                if(node.left!=null)     queue.add(node.left);
                if(node.right!=null)    queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}

/*  思路二：第一层是奇数，那如果第一层结束后没空，就是第二层
    思路三: List 如果是偶数层，使用if(res.size() % 2 == 1) Collections.reverse(tmp);
*/