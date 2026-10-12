package palindromeLinkedList;

import utils.ListNode;

public class Main {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            if(fast.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = null;
        while(slow != null){
            ListNode previousNode = tmp;
            tmp = slow;
            slow = tmp.next;
            tmp.next = previousNode;

        }
        while(tmp != null){
            if(head.val != tmp.val) return false;
            head=head.next;
            tmp=tmp.next;
        }
        return true;
    }
}
