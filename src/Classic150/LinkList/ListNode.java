package Classic150.LinkList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode(int[] val){
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
