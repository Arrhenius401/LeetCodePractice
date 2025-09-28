package Classic150.LinkList;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

public class problem3 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        int size = 0;
        ListNode prehead = new ListNode(-1, head);
        ListNode temp = prehead.next;

        // 计数链表长度
        while (temp!=null){
            size++;
            temp = temp.next;
        }

        reverse(prehead, size);
        reverse(prehead, k%size);

        temp = prehead;
        for (int i = 0; i < k%size; i++) {
            temp = temp.next;
        }
        reverse(temp, size - k%size);


        return prehead.next;
    }

    // 翻转链表的前节点和翻转规模
    public void reverse(ListNode prehead, int k){
        ListNode head = prehead.next;
        ListNode first = head, second = first.next, third = null;

        for (int i = 0; i < k-1; i++) {
            third = second.next;
            second.next = first;

            first = second;
            second = third;
        }

        prehead.next = first;
        head.next = second;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        problem3 p = new problem3();

        p.rotateRight(head, 2);
    }
}
