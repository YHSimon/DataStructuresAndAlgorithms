package day01;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class Test {

   Stack<Integer> stack1 =new Stack<>();
   Stack<Integer> stack2 =new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public void pop() {
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    //返回最小的  只是寻找 不是出栈
    public int min() {
        int min=Integer.MAX_VALUE;
        while(stack1.size()>0){
            int temp=stack1.pop();
            if(temp<min){
                min=temp;
            }
            stack2.push(temp);
        }
        while(stack2.size()>0){
            stack1.push(stack2.pop());
        }
        return min;
    }
}
