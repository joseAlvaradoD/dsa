import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        int [] nums = {3,2,3};
        int candidate = majorityElement(nums);
        System.out.println(candidate);

        nums = new int[]{2,2,1,1,1,2,2};
        candidate = majorityElement(nums);
        System.out.println(candidate);
    }

    public static int majorityElement(int[] nums){
        int candidate = findCandidate(nums);
        int count=0;
        for(int num : nums){
            if(num == candidate){
                count++;
            }
            if(count > (nums.length/2)){
                return candidate;
            }
        }

        return -1;
    }

    public static int findCandidate(int[] nums){
        int elem = 0;
        int count = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[elem] == nums[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                elem = i;
                count = 1;
            }
        }

        return nums[elem];
    }

}