package Classic150.LinkList;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class problem2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prehead = new ListNode(-101, head);
        Set<Integer> set = new HashSet<>();
        Set<Integer> preSet = new HashSet<>();

        ListNode temp = prehead.next;
        while (temp != null){
            if(preSet.contains(temp.val)){
                set.add(temp.val);
            } else {
                preSet.add(temp.val);
            }

            temp = temp.next;
        }

        ListNode first = prehead;
        ListNode second = first.next, third = null;

        while (second != null){
            third = second.next;
            if(set.contains(second.val)){
                first.next = third;
                second = third;
            } else {
                first = second;
                second = third;
            }

        }

        return prehead.next;
    }
}
