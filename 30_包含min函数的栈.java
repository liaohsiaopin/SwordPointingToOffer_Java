/*  push pop O(1)  min O(n)
    思考：
    1.  如果最上方放的是最小元素，那pop的就不是最后进来的了，也就不是栈了，因此不可
    2.  如果栈中增加一个成员变量保存最小元素， 那最小元素弹出来了怎么办呢？

    1.  数据栈：保存所有元素，保证pop top push
    2.  辅助栈：B中存储A中非严格降序的元素，则栈A中的最小元素始终对应栈B的栈顶元素，即min()只需要返回栈B的栈顶元素
    3.  只需要维护好辅助栈，使其非严格降序，即可实现min()为O(1)

    min是找到最小的元素 不弹出来

    有两种方案：
    1. push到A的时候，如果是更小的值才push到B
    2. push到A的时候，如果不是更小的值，就push一个B的top
*/

// 85.60 100
class MinStack {
    Stack<Integer> A,B;  //Integer不是基本的数据类型int，用==比较Integer是比较它的地址，要用equals比较
    /** initialize your data structure here. */
    public MinStack() {
        A=new Stack<>();
        B=new Stack<>();
    }
    
    public void push(int x) {
        A.add(x);
        if(B.empty()||B.peek()>=x)  
            B.add(x);
    }
    
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int min() {
        return B.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

class MinStack {
    Stack<Integer> A,B;  //Integer不是基本的数据类型int，用==比较Integer是比较它的地址，要用equals比较
    /** initialize your data structure here. */
    public MinStack() {
        A=new Stack<>();
        B=new Stack<>();
    }
    
    public void push(int x) {
        A.add(x);
        if(B.empty()||B.peek()>=x) B.add(x);
        else B.add(B.peek());
    }
    
    public void pop() {
        A.pop();
        B.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int min() {
        return B.peek();

    }
}