package Hot100.LinkList;

public class problem2 {
    //迭代解
    public ListNode reverseList(ListNode head) {
        ListNode firstNode = null;
        ListNode secondNode = head;
        ListNode thirdNode = null;

        while (secondNode != null){
            thirdNode = secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = thirdNode;
        }

        return firstNode;
    }

    //递归解
    public ListNode reverseList2(ListNode head) {
        ListNode first = null;
        ListNode second = head;
        ListNode third = null;

        return recursion(first, second, third);
    }

    public ListNode recursion(ListNode first, ListNode second, ListNode third) {
        if(second == null){
            return first;
        }

        third = second.next;
        second.next = first;
        first = second;
        second = third;

        return recursion(first, second, third);
    }
}
