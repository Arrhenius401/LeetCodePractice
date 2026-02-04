package Classic150.LinkList;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

import java.util.List;

public class problem6 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode();
        ListNode temp = prehead;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while (list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        return prehead.next;
    }
}
