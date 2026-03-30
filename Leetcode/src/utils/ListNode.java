package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createListNode(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode dummy = head;
        for (int i = 1; i < nums.length ; i++) {
            dummy.next = new ListNode(nums[i]);
            dummy = dummy.next;
        }

        return head;
    }

    public static void print(ListNode dummy){
        while(dummy != null){
            System.out.print(dummy.val+", ");
            dummy = dummy.next;
        }
        System.out.println();
    }
}
