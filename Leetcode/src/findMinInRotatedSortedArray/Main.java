package findMinInRotatedSortedArray;

/*
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
    Array
    Binary Search
*/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3,4,5,6,1,2}));
        System.out.println(solution.findMin(new int[]{4,5,6,7}));
    }
}
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }


}