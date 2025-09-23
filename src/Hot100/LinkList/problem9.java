package Hot100.LinkList;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

public class problem9 {
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode zero, second, third;

        if(first == null || first.next == null){
            return head;
        }

        zero = null;
        while (first != null && first.next != null){
            if(first.equals(head)){
                head = head.next;
            }
            second = first.next;
            third = second.next;

            if(zero != null){
                zero.next = second;
            }

            second.next = first;
            first.next = third;

            zero = first;
            first = third;
        }

        return head;
    }
}
