/*  思路    进队：push stack1
            出队：stack2非空则直接出stack2，否则stack1全部弹入stack2
            还需要考虑队空时候的出队 return stack2.isEmpty()? -1:stack2.pop();
*/

class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty()? -1:stack2.pop();
        }
    }
}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */