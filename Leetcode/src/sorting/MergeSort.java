package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){
        int[] array1 = new int[]{50,70,60,90,80,10,100,5};
        int[] array2 = new int[]{10,9,8,7,6,5,4,3,2,1,0};
        for (int n: mergeSort(array1)){
            System.out.print(n+ " ");
        }
        System.out.println();
        for (int n: mergeSort(array2)){
            System.out.print(n+ " ");
        }
    }

    public static int[] mergeSort(int[] array){
        if(array.length <= 1){
            return array;
        }
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }
    public static int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length+right.length];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] < right[rightIndex]){
                merged[index] = left[leftIndex];
                leftIndex++;
            }else{
                merged[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }
        while(leftIndex < left.length){
            merged[index] = left[leftIndex];
            index++;
            leftIndex++;
        }
        while(rightIndex < right.length){
            merged[index] = right[rightIndex];
            index++;
            rightIndex++;
        }
        return merged;
    }
}
