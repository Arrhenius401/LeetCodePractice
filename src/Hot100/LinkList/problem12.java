package Hot100.LinkList;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

public class problem12 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail){
        ListNode fast = head;
        ListNode slow = head;

        if(head == null){
            return head;
        }

        if(head.next == tail){
            head.next = null;
            return head;
        }

        //对于偶数元素的中位数中间靠后
        while (fast != tail){
            fast = fast.next;
            slow = slow.next;
            if(fast != tail){
                fast = fast.next;
            }
        }

        ListNode head1 = sortList(head, slow);
        ListNode head2 = sortList(slow, tail);

        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode prehead = new ListNode(-1);
        ListNode temp = prehead, temp1 = head1, temp2 = head2;

        while (temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null){
            temp.next = temp1;
        }
        if (temp2 != null){
            temp.next = temp2;
        }

        return prehead.next;
    }
}
