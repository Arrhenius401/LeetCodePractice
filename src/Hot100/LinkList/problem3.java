package Hot100.LinkList;

import java.util.ArrayList;

public class problem3 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> val = new ArrayList<>();

        while (head != null){
            val.add(head.val);
            head = head.next;
        }

        int l = 0, r = val.size()-1;
        while (l<r){
            if(val.get(l++) != val.get(r--)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[] val = {1,2,2,1};
        ListNode l = new ListNode(val);
        problem3 p = new problem3();

        System.out.println(p.isPalindrome(l));
    }
}
