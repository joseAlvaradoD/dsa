package jjad.dsa.kthlargest;

import java.util.Random;

public class Main {
    /*
    Kth Largest/Smallest Number is an array
    Given an integer array nums and an integer k, return the k

    th largest element in the array.

    Note that it is the k

    th largest element in the sorted order, not the k

    th distinct element.

    Can you solve it without sorting?
    Example 1:
    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5
    Example 2:
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4
    Constraints:
     1 <= k <= nums.length <= 105
     -104 <= nums[i] <= 104
     */

    public static void main(String[] args){
        int[] arr = {3,2,1,5,6,4};
        System.out.println(kthLargestBruteForceSolution(arr,2));

        arr = new int[] {3,2,3,1,2,4,5,5,6};
        System.out.println(kthLargestBruteForceSolution(arr,4));

        arr = new int[] {-1,-1};
        System.out.println(kthLargestBruteForceSolution(arr,2));


        arr = new int[] {3,2,1,5,6,4};
        System.out.println(kthLargest(arr, 0, arr.length-1, 2));


        arr = new int[] {3,2,3,1,2,4,5,5,6};
        System.out.println(kthLargest(arr, 0, arr.length-1, 4));

        arr = new int[] {-1,-1};
        System.out.println(kthLargest(arr, 0, arr.length-1,2));

    }


    //Time complexity O(n*k) this could be O(n^2)
    //Auxiliary space O(1)
    public static int kthLargestBruteForceSolution(int[] numbers, int k){
        if(numbers.length<k){
            return -1;
        }

        int largestNumberIndex = 0;
        int ans = 0;

        for(int j = 0; j < k; j++){
            int tmp = Integer.MIN_VALUE;
            for(int i = 0; i < numbers.length; i++){
                if(tmp < numbers[i]){
                    largestNumberIndex = i;
                    tmp = ans = numbers[i];

                }

            }
            numbers[largestNumberIndex] = Integer.MIN_VALUE;
        }


        return ans;
    }
    //Quick select method
    /*
    int low the last position in array for
    */

    static int kthLargest(int[] arr, int low, int high, int k){

        if(low == high){
            return arr[low];
        }

        if(low < high){

            Random randomNum = new Random();

            int partitionIndex = low + randomNum.nextInt(high-low);

            partitionIndex = partition(arr, low, high, partitionIndex);

            if(partitionIndex == arr.length - k)
                return arr[partitionIndex];

            if(partitionIndex > arr.length - k)
                return kthLargest(arr, low, partitionIndex-1, k);

            return kthLargest(arr,partitionIndex+1, high, k);
        }
        return Integer.MIN_VALUE;
    }

    public static int partition(int[] arr, int low, int high, int partitionIndex){
        int pivot = arr[partitionIndex];

        swap(arr, partitionIndex, high);

        int i = low-1;

        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
