package removeNthNodeFromEndOfList;

/*
    https://leetcode.com/problems/remove-nth-node-from-end-of-list
    Linked List
    Two Pointers
 */

import utils.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.createListNode(new int[]{1,2,3,4,5});
        ListNode.print(solution.removeNthFromEnd(listNode,2));
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

}