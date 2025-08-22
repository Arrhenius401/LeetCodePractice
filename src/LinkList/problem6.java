package LinkList;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

public class problem6 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = null;
        ListNode newHead = null;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(newHead == null){
                    newHead = list1;
                    newList = newHead;
                }else {
                    newList.next = list1;
                    newList = newList.next;
                }

                list1 = list1.next;
            }else {
                if(newHead == null){
                    newHead = list2;
                    newList = newHead;
                }else {
                    newList.next = list2;
                    newList = newList.next;
                }

                list2 = list2.next;
            }
        }

        if (list1 != null){
            if(newHead == null){
                return list1;
            }

            newList.next = list1;
        }

        if (list2 != null){
            if(newHead == null){
                return list2;
            }

            newList.next = list2;
        }

        return newHead;
    }
}
