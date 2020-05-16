package day13;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Test t = new Test();
        t.reverseKGroup(n1, 2);
    }

    /**
     * 0ms
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 3ms
     * <p>
     * 链表上直接操作
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    /**
     * 6ms  7%
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        //存入集合
        List<ListNode> nodes = new ArrayList<>();
        while (true) {
            if (head == null) {
                break;
            }
            nodes.add(head);
            head = head.next;
        }
//        System.out.println(nodes.toString());
        int len = nodes.size();
        int mode = len % k;
        for (int i = 0; i < len - mode; i += k) {
            //首尾交换规律
            int index = i + (i + k - 1);
            for (int j = i; j < i + k / 2; j++) {
                ListNode temp = nodes.get(j);
                nodes.set(j, nodes.get(index - j));
                nodes.set(index - j, temp);
            }
        }
        ListNode head2 = new ListNode(-1);
        ListNode temp = head2;
        nodes.get(len - 1).next = null;
        for (ListNode node : nodes) {
            temp.next = node;
            temp = temp.next;
        }
//        list(head2.next);
        return head2.next;

    }

    public void list(ListNode node) {
        ListNode head = node;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}