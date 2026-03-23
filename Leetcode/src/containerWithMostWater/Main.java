package containerWithMostWater;

/*
    https://leetcode.com/problems/container-with-most-water
    Array, Two Pointers, Greedy
 */

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println("Result: " + solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("Result: " + solution.maxArea(new int[]{1,1}));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;

        while(right > left){
            int maxHeight = height[left]<height[right]?height[left]:height[right];
            int tmpArea = (right-left) * maxHeight;

            area = tmpArea>area?tmpArea:area;

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return area;
    }
}
