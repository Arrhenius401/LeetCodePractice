package Hot100.LinkList;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

public class problem10 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = new ListNode(-1);
        ListNode prek = prev;
        ListNode first, second;

        prev.next = temp;

        while (temp != null){
            ListNode zero = temp;
            for(int i=0; i<k; i++){
                if(zero == null){
                    return prev.next;
                }
                zero = zero.next;
            }

            ListNode pret = temp;
            first = temp;
            temp = zero;
            for(int i=0; i<k; i++){
                second = first.next;
                first.next = zero;

                zero = first;
                first = second;
            }

            prek.next = zero;
            prek = pret;
        }

        return prev.next;
    }
}
