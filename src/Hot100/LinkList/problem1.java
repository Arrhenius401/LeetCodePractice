package Hot100.LinkList;

//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//个人注解：此处相交是指内存上结构上完全一致，而不是仅限于指针的数据域

import java.util.HashSet;
import java.util.Set;

public class problem1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null){
            visited.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null){
            if(visited.contains(temp)){
                break;
            }
            temp = temp.next;
        }

        return temp;
    }
}
