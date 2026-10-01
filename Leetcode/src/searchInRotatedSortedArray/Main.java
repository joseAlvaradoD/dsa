package searchInRotatedSortedArray;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 1));
        System.out.println(solution.search(new int[]{3,5,6,0,1,2}, 4));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int m = l + (r-l);
            if(nums[m] == target){
                return m;
            }
            if(nums[l] <= nums[m]){
                if(target > nums[m] || target < nums[l]){
                    l = m + 1;
                }else{
                    r = m -1;
                }
            }else{
                if(target < nums[m] || target > nums[r]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }

        return res;
    }
}
