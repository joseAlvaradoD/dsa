package utils;

public class Arrays {
    public static void print(int[] nums){
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
