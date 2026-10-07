package moveZeroes;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        nums = new int[]{0};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        nums = new int[]{1,0};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }
    public static void moveZeroes(int nums[]){
        int r = 0;
        int n = nums.length;

        for(int l = 0; l < n; l++){
            if(nums[l] != 0){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                r++;
            }
        }
    }
}
