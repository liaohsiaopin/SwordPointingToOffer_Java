/*  二叉搜索树的中序遍历是递增的，将二叉搜索树转换成一个排序的循环双向链表，包含三个要素：
    1.  排序链表。节点从小到大排序，因此使用中序遍历从小到大访问树的节点
    2.  双向链表。pre.right=cur cur.left=pre
    3.  循环链表. head.left=tail tail.right=head;

    使用中序遍历访问各个节点cur，并在访问的时候构建cur和前驱结点pre的引用指向。
    中序遍历完成后，最后构建头结点和尾节点的引用指向即可

    算法流程：
    dfs(cur)：递归中序遍历：
        1.  终止条件。 cur为空
        2.  递归左子树  dfs(cur.left)
        3.  构建链表：
            1.  pre为空：   代表正在访问链表头结点，记为head
            2.  pre不为空： 修改双向节点的引用，即pre.right=cur cur.left=pre
            3.  保存cur     更新pre=cur，即节点cur是后继节点的pre
        4.  递归右子树
    
    treeToDoublyList(root):
        1.  特例处理：root==null 返回空
        2.  初始化：空节点pre
        3.  转化为双向链表：调用dfs(root)
        4.  循环构建链表：中序遍历完成后，head指向头结点，pre指向为节点。因此修改pre和head
        5.  返回值：head
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre,head;

    public Node treeToDoublyList(Node root) {
        if(root==null)  return null;
        dfs(root);
        head.left=pre;
        pre.right=head;
    }

    void dfs(Node cur){
        if(cur==null)   return ;
        dfs(cur.left);
        if(pre!=null)   pre.right=cur;  //不是头结点
        else head=cur;  //头结点
        cur.left=pre;
        pre=cur;
        dfs(cur.right);
    }
}


class Solution {
    Node pre,head;

    public Node treeToDoublyList(Node root) {
        if(root==null)  return null;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
        
    }

    void dfs(Node cur){
        if(cur==null)   return;
        dfs(cur.left);
        if(pre==null)   head=cur;
        else pre.right=cur;
        cur.left=pre;
        pre=cur;
        dfs(cur.right);   
    }
}