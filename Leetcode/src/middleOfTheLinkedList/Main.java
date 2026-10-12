package middleOfTheLinkedList;

import utils.ListNode;

public class Main {

    public ListNode middleNode(ListNode  head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            if(fast.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
