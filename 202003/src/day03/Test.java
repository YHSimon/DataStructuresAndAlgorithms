package day03;

import java.util.ArrayList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(t.FindKthToTail(head, 1).val);

//        int[] a=new int[]{1,2,3,4,5,6,7,9};
//        t.reOrderArray(a);
//        for (int i = 0; i <a.length ; i++) {
//            System.out.print(a[i]);
//        }

//        System.out.println(t.Power(2, -3));
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头
     */
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head, int k) {


        if (head == null) {
            return head;
        }
        if (k <= 0) {
            return null;
        }

        //方式二
        Stack<ListNode> stack = new Stack<>();
        while (true) {
            if (head == null) {
                break;
            }
            stack.add(head);
            head = head.next;
        }
        ListNode res = null;
        for (int i = 1; i <= k; i++) {
            if (stack.size() > 0) {
                res = stack.pop();
            } else {
                res = null;
            }
        }
        return res;

          //方式一
//        ListNode temp=head;
//        int count=0;
//        while(temp!=null){
//            count++;
//            temp=temp.next;
//        }
//        ListNode res=null;
//        int len=count+1-k;
//        for(int i=1;i<=len;i++){
//            res=head;
//            head=head.next;
//        }
//        return res;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * @param array
     */

    public void reOrderArray(int[] array) {
        int length = array.length;
        int count = 0;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 0) {
                even.add(array[i]);
            } else {
                count++;
                odd.add(array[i]);
            }
        }
        for (int i = 0; i < count; i++) {
            array[i] = odd.get(i);
        }
        for (int i = count; i < length; i++) {
            array[i] = even.get(i - count);
        }
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double temp = 1;
        if (exponent > 0) {
            for (int i = 1; i <= exponent; i++) {
                temp *= base;
            }
        }
        if (exponent < 0) {
            for (int i = 1; i <= Math.abs(exponent); i++) {
                temp /= base;
            }
        }
        return temp;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}