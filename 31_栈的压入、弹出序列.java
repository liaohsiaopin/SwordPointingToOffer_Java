/*  给定一个压入和弹出序列，则压入、弹出操作的顺序是唯一确定的。
    1.  每弹入一个元素，检查剩余的出栈队列，如果栈顶元素和剩余队列中的第一个相同，则出栈，并检查剩余的队列。否则下一个元素进栈
*/
// 82.23 100
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty()&&stack.peek()==popped[i]){  // 没有stack.pop()
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

