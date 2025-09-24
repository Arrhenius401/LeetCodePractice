package Classic150.LinkList;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

public class problem1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode prehead = new ListNode(-1, head);

        // 寻找翻转部分的头部和 尾部
        ListNode first = prehead;
        ListNode zero = null;
        for(int i=0; i<=right; i++){
            if(i == left-1){
                zero = first;
            }
            first = first.next;
        }

        ListNode second = zero.next;
        ListNode third = null;
        for(int i=0; i<=right-left; i++){
            third = second.next;
            second.next = first;

            first = second;
            second = third;
        }

        zero.next = first;

        return prehead.next;
    }
}
