package Hot100.LinkList;

public class problem13 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        int k = lists.length-1;

        return mergeKLists(lists, 0, k);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r){
        int mid;

        if(l == r){
            return lists[l];
        }else if(l == r-1){
            return merge(lists[l], lists[r]);
        } else if(l < r){
            mid = (l+r)/2;
            ListNode head1 = mergeKLists(lists, l, mid);
            ListNode head2 = mergeKLists(lists, mid+1, r);

            return merge(head1, head2);
        }

        return null;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (head1 != null && head2 != null){
            if(head1.val <= head2.val){
                prev.next = head1;
                head1 = head1.next;
            }else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }

        if(head1 != null){
            prev.next = head1;
        }

        if(head2 != null){
            prev.next = head2;
        }

        return prehead.next;
    }
}
