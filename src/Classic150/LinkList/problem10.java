package Classic150.LinkList;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

public class problem10 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prehead = new ListNode();
        prehead.next = head;

        ListNode temp = prehead;

        while (true) {
            ListNode curhead = temp.next;
            ListNode curTail = temp.next;

            // 检验是否能够翻转
            for (int i = 0; i < k; i++) {
                if(curhead != null){
                    curhead = curhead.next;
                }else {
                    return prehead.next;
                }
            }

            // 实现翻转
            ListNode first = curhead, second = curTail, third ;
            for (int i = 0; i < k; i++) {
                third = second.next;
                second.next = first;

                first = second;
                second = third;
            }

            temp.next = first;
            temp = curTail;
        }
    }
}
