package LinkList;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

public class problem8 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode ptr = head;

        while (ptr != null){
            len++;
            ptr = ptr.next;
        }

        if(len-n == 0){
            return head.next;
        }

        ptr = head;
        for(int i=0; i<len-n+1; i++){
            if(i == len-n-1){
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
        }

        return head;
    }
}
