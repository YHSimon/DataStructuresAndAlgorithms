package day09;

import java.util.Stack;

/**
 * 两个辅助栈实现 最小栈
 * 6ms
 */
public class MinStack2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack2(){
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
    }

    public void push(int x){
        stack.add(x);
        if(!minStack.isEmpty()){
            if(x<=minStack.peek()){
                minStack.push(x);
            }
        }else{
            minStack.push(x);
        }
    }

    public void pop(){
        int pop=stack.pop();
        int top=minStack.peek();
        if(pop==top){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
