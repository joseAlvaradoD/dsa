package reverseLinkedList;

import utils.ListNode;

public class Main {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;

        while(head != null){
            ListNode prev = tail;
            tail = head;
            head = tail.next;
            tail.next = prev;

        }
        return tail;
    }
}
