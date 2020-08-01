/*  复杂链表：节点的指针除了next，还有一个指向其他节点或者null的指针
    浅拷贝：    只复制指针，不复制对象
    深拷贝：    都复制
*/

/*
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*  方法一  DFS&BFS
    将链表看成图，图有深度优先和广度优先两种遍历方式，因此该链表也有两种方法

    深度优先：
    1.  从头结点开始拷贝
    2.  由于一个节点可能被多个指针指到，因此如果该节点已经被拷贝，就不需要重复拷贝
    3.  如果还没拷贝该节点，则创建一个新节点进行拷贝，并将拷贝过的节点保存在哈希表中
    4.  使用递归拷贝所有的next节点，再递归拷贝所有的random节点
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)  return null;
        Node node=head;
        Map<Node,Node> myMap=new HashMap<>();

        //构造每一个节点
        while(node!=null){
            myMap.put(node,new Node(node.val));  //key node  val：新node的addr
            node=node.next;
        }

        node=head;
        while(node!=null){
            myMap.get(node).next=map.get(node.next);
            myMap.get(node).random=myMap.get(node.random);
            node=node.next;
        }

        return myMap.get(head);
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        
    }
}