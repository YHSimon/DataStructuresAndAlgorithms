package day04;

public class Main {
    public static void main(String[] args) {
        Main m=new Main();
        RandomListNode pHead=new RandomListNode(1);
        RandomListNode r2=new RandomListNode(2);
        RandomListNode r3=new RandomListNode(3);
        pHead.next=r2;
        r2.next=r3;
        pHead.random=r2;
        r2.random=r3;
        System.out.println(pHead);
        RandomListNode res=m.Clone(pHead);
        System.out.println(res);
    }

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        //1.复制每一个节点 转成 A->A1->B->B1...
        RandomListNode cur=pHead;
        while(cur!=null){
            RandomListNode clone=new RandomListNode(cur.label);
            RandomListNode next=cur.next;
            clone.next=next;
            cur.next=clone;
            cur=next;
        }
        //此时cur=null;此时pHead已经是复制完每个节点的新链表

        //2.重新遍历链表，复制每个原节点的Random节点
        cur=pHead;
        while(cur!=null){
            cur.next.random=cur.random==null?null:cur.random.next;
            cur=cur.next.next;
        }

        //3.拆分链表

        cur=pHead;
        RandomListNode pCloneHead=pHead.next;
        while (cur!=null){
            RandomListNode cloneNode=cur.next;
            cur.next=cloneNode.next;
            cloneNode.next=cloneNode.next==null?null:cloneNode.next.next;
            cur=cur.next;
        }
        return  pCloneHead;
    }

}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return String.valueOf(this.label);
    }
}
