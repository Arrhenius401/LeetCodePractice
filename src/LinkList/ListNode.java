package LinkList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] val){
        ListNode next = null;
        ListNode cur;

        for(int i=val.length-1; i>=1; i--){
            cur = new ListNode(val[i], next);
            next = cur;
        }

        this.val = val[0];
        this.next = next;
    }
}
