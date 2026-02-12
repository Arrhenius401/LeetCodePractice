package Classic150.LinkList;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

public class problem8 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    public ListNode sort(ListNode head, ListNode tail){
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }

        ListNode list1 = sort(head, slow);
        ListNode list2 = sort(slow, tail);
        return mergeLists(list1, list2);
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode();
        ListNode temp = prehead;

        while (list1 != null && list2 != null){
            if(list1.val > list2.val){
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }

        if(list1 != null){
            temp.next = list1;
        }

        if(list2 != null){
            temp.next = list2;
        }

        return prehead.next;
    }
}
