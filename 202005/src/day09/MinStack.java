package day09;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */

/**
 * 单辅助栈 单变量
 * 6ms
 */
public class MinStack {
    private Stack<Integer> stack;
    private int min;
    public MinStack(){
        this.stack=new Stack<>();
        this.min=Integer.MAX_VALUE;
    }

    public void push(int x){
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop(){
        if(stack.pop()==min){
            min=stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return min;
    }

}
