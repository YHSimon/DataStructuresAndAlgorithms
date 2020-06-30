package day15;

import java.util.Stack;

//405ms
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        this.stack1=new Stack<>();
        this.stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()) return -1;
        while(!stack1.isEmpty()&&stack1.size()>1){
            stack2.add(stack1.pop());
        }
        int res=stack1.pop();
        while(!stack2.isEmpty()){
            stack1.add(stack1.pop());
        }
        return res;
    }
}
