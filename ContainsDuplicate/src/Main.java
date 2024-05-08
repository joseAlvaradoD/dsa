import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsDuplicates(arr));

        arr = new int[]{1,2,3,4};
        System.out.println(containsDuplicates(arr));

        arr = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicates(arr));
    }

    public static boolean containsDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();

        for(int a : arr){
            if(set.contains(a)){
               return true;
            }
            set.add(a);
        }
        return false;
    }
}