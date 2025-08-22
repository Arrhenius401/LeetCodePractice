package LinkList;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

public class problem7 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isAdd = false;
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null){
            int val = l1.val + l2.val;
            if(isAdd){
                val++;
                isAdd = false;
            }

            if(val/10 > 0){
                isAdd = true;
            }

            l1.val = val%10;
            prev.next = l1;
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int val = l1.val;
            if(isAdd){
                val++;
                isAdd = false;
            }

            if(val/10 > 0){
                isAdd = true;
            }

            l1.val = val%10;
            prev.next = l1;
            prev = prev.next;
            l1 = l1.next;
        }

        while (l2 != null){
            int val = l2.val;
            if(isAdd){
                val++;
                isAdd = false;
            }

            if(val/10 > 0){
                isAdd = true;
            }

            l2.val = val%10;
            prev.next = l2;
            prev = prev.next;
            l2 = l2.next;
        }

        if (isAdd){
            prev.next = new ListNode(1);
        }

        return prehead.next;
    }
}
