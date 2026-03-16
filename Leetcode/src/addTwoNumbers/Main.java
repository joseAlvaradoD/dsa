package addTwoNumbers;

/*
    https://leetcode.com/problems/add-two-numbers
 */
public class Main {

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        final ListNode head = listNode;
        int quotient = 0;
        int sum;
        while(l1 != null || l2 != null){
            sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum+=quotient;
            if(sum > 9){
                listNode.val = sum%10;
                quotient = 1;
            }else{
                listNode.val = sum;
                quotient = 0;
            }

            if(l1 != null || l2 != null){
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }
        if(quotient == 1) listNode.next = new ListNode(quotient);
        return head;
    }
}