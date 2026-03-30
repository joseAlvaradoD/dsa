package nextPermutation;

/*
    https://leetcode.com/problems/next-permutation
    Array
    Two Pointers
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3};
        solution.nextPermutation(nums);
        print(nums);//1,3,2

        nums = new int[]{1,3,2};
        solution.nextPermutation(nums);
        print(nums);//2,1,3

        nums = new int[]{3,2,1};
        solution.nextPermutation(nums);
        print(nums);//1,2,3

        nums = new int[]{1,1,5};
        solution.nextPermutation(nums);
        print(nums);//1,5,1
    }
    private static void print(int[] nums){
        System.out.print("[");
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
            if(i<nums.length-1){
                System.out.print(", ");
            }

        }
        System.out.println("]");
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = n-2;

        while(left >= 0 && nums[left] >= nums[left+1]){
            left--;
        }

        if(left < 0){
            reverse(nums, 0, n-1);
        }else{
            int right = n - 1;
            while (right > left && nums[right] <= nums[left]) {
                right--;
            }
            swap(nums, left, right);

            reverse(nums, left + 1, n - 1);
        }
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
