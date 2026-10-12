package searchInsertPosition;

public class Main {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while(l < r){
            int i = l + ((r-l)/2);

            if(target > nums[i]){
                l=i+1;
            }else{
                r=i;
            }
        }
        return l;
    }
}
