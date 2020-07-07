/*  镜像不仅仅是把左右子树的位置换了，对应的父节点也会变
    思路：先序遍历所有的节点，如果该节点有子节点，则交换子节点。
*/

/*  递归方法：
    1.  终止条件：当前节点为null
    2.  递推工作：
        1. 初始化节点tmp，暂存root的左节点
        2. 开启递归右子节点，并将返回值作为root的左子节点
        3. 开启递归的左子节点，并将返回值作为root的右子节点
    3. 返回值，当前节点root

    时空复杂度：O(N)   O(N):递归栈

    结果：100 100
*/
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(temp);
        return root;
    }
}

/*  辅助栈：利用栈遍历所有的节点，交换每个节点的左右子节点

    流程：
    1. root为空，返回null
    2. 初始化：栈，加入根节点root
    3. 循环交换：当栈空的时候跳出
        1. 出栈，记为node
        2. 添加子节点，将node左右子节点入栈
        3. 交换：交换node的左右子节点
    4. 返回值： 返回根节点root
*/
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)  return null;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while(!stack.empty()){
            TreeNode node=stack.pop();
            if(node.left!=null) stack.add(node.left);
            if(node.right!=null) stack.add(node.right);
            TreeNode temp=node.left; //不管是否为null都交换
            node.left=node.right;
            node.right=temp;
        }
        return root;    
    }
}
