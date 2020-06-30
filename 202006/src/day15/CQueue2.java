package day15;

import java.util.Stack;

//66ms

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 提示：
 *  1 <= values <= 10000
 *  最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class CQueue2 {
    //负责入队列
    Stack<Integer> stack1;
    //负责出队列
    Stack<Integer> stack2;

    public CQueue2() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty()?-1:stack2.pop();
        }
    }

}
