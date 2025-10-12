package Classic150.LinkList;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//你应当 保留 两个分区中每个节点的初始相对位置。

public class problem4 {
    public ListNode partition(ListNode head, int x) {
        ListNode prehead = new ListNode(-1, head);
        ListNode small = null, large = null;
        ListNode ptr = prehead.next;
        while (ptr != null){
            if(ptr.val < x && small == null){
                small = ptr;
            } else if (ptr.val >= x && large == null){
                large = ptr;
            } else if (large != null && small != null) {
                break;
            }
            ptr = ptr.next;
        }

        if(small == null || large == null){
            return prehead.next;
        }

        ListNode preLarge = large;
        ListNode preSmall = small;
        ptr = prehead.next;
        while (ptr != null){
            if(ptr.val < x && small != ptr){
                small.next = ptr;
                small = small.next;
            } else if (ptr.val >= x && large != ptr){
                large.next = ptr;
                large = large.next;
            }
            ptr = ptr.next;
        }
        // 收尾
        large.next = null;
        small.next = preLarge;
        prehead.next = preSmall;

        return prehead.next;
    }
}
