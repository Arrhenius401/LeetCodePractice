package Classic150.LinkList;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

public class problem5 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1, head);
        ListNode temp = pre.next;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int del = count - n;
        count = 0;
        temp = pre;
        while (temp != null) {
            if(count == del){
                temp.next = temp.next.next;
                break;
            }
            count++;
            temp = temp.next;
        }

        return pre.next;
    }
}
