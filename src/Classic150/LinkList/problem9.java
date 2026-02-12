package Classic150.LinkList;

//给你一个链表数组，每个链表都已经按升序排列。
//
//请你将所有链表合并到一个升序链表中，返回合并后的链表。

public class problem9 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        ListNode pre = new ListNode();
        pre.next = lists[0];

        for (int i = 1; i < lists.length; i++) {
            ListNode first = pre.next;
            ListNode second = lists[i];
            ListNode temp = pre;

            while (first != null && second != null){
                if(first.val > second.val){
                    temp.next = second;
                    second = second.next;
                }else {
                    temp.next = first;
                    first = first.next;
                }
                temp = temp.next;
            }

            if(first != null){
                temp.next = first;
            }

            if(second != null){
                temp.next = second;
            }

        }

        return pre.next;
    }
}
