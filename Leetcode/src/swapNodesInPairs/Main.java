package swapNodesInPairs;

import utils.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.createListNode(new int[]{1,2,3,4});
        ListNode.print(solution.swapPairs(listNode));
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);

        second.next = first;

        return second;
    }

}