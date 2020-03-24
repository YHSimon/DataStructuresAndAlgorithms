package day2;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class StackImplQueue {
    static Stack<Integer> stack1=new Stack<>();
    static Stack<Integer> stack2=new Stack<>();

    public static void main(String[] args) {
        StackImplQueue stackImplQueue=new StackImplQueue();
        stackImplQueue.push(1);
        stackImplQueue.push(2);
        int a = stackImplQueue.pop();
        int b = stackImplQueue.pop();
        System.out.println(a+" "+b);
    }

    public void push(int node){
        stack1.add(node);
    }
    public  int pop(){
        while (stack1.size()>0){
            stack2.add(stack1.pop());
        }
        int res=stack2.pop();
        //注意不能stack1=stack2进行赋值，死循环
        while (stack2.size()>0){
            stack1.add(stack2.pop());
        }
        return res;
    }
}
