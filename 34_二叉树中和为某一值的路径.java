/*  二叉树回溯问题，通过先序遍历+路径记录两个部分。 路径是从根节点开始的，先序遍历才满足
    访问子节点的时候，把父节点加进去。回到父节点的时候，把子节点删掉
    当和等于sum的时候，将这个路径加入到结果列表里。
*/
class Solution {
    LinkedList<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;
    }

    public void recur(TreeNode root, int tar){
        if(root==null)  return;
        path.add(root.val);
        tar -=root.val;
        if(tar==0 && root.left==null && root.right==null)
            res.add(new LinkedList(path)); //复制一个path到里面，否则path改变了res里面的值也会改变
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();//删除这个
    }
}


class Solution {
    LinkedList<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;
    }

    public void recur(TreeNode root, int tar){
        if(root==null)  return;
        tar-=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null && tar==0)
            res.add(new LinkedList(path));
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();
    }
}
