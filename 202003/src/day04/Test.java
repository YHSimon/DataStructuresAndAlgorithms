package day04;


import java.util.List;

public class Test {

    public static void main(String[] args) {

        Test t=new Test();
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(5);

        ListNode l2=new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(6);

//        t.Merge(l1, l2);
          t.Merge2(l1, l2);
    }

    /**
     * 非递归
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        ListNode head=new ListNode(-1);
        head.next=null;
        ListNode root=head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                head.next=list1;
                head=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
        }
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        return root.next;
    }
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     *
     * 递归
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return  list1;
        }
        ListNode pHead=null;
        if(list1.val<list2.val){
            pHead=list1;
            pHead.next=Merge(list1.next, list2);
        }else{
            pHead=list2;
            pHead.next=Merge(list1, list2.next);
        }
        return  pHead;
    }

}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val+"";
    }
}