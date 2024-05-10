import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(balancedWord());

        int[] arr = {2,2,1};
        System.out.println(findSingle(arr));
        arr = new int[]{4,1,2,1,2};
        System.out.println(findSingle(arr));
        arr = new int[]{1};
        System.out.println(findSingle(arr));
    }

    public static int findSingle(int[] arr){
        int ans = 0;

        for(int i : arr){
            ans = ans^=i;
        }

        return ans;
    }



    //214
    public static int balancedWord(){
        int n = 2;
        int d = 2;
        int count = 0;
        byte a = 'a';//97
        byte z = 'z';//122
        int possibleCombination = (int)Math.pow((z-a),n);


        byte letter = 97;
        int i = 0;
        int j = 0;
        Random r = new Random();
        Set<String> set = new HashSet<>();
        while (set.size() < possibleCombination) {
            byte[] word = new byte[n];
            for(j = 0; j < n; j++){
                word[j] = (byte)(r.nextInt(z-a) + a);
            }
            String str = new String(word);
            if(!set.contains(str)){
                set.add(str);
            }
        }
        System.out.println(set.size());

        boolean isBalanced = true;
        for(String word:set){
            for(int x = 1; x < n; x++){
                if(Math.abs(word.charAt(x) - word.charAt(x-1)) <= d){
                    isBalanced = true;
                }else{
                    isBalanced = false;
                    break;
                }
            }
            if(isBalanced){
                count++;
            }

        }


        return count;
    }

    public static void print(byte arr[]){
        System.out.print("[");
        System.out.print(new String(arr));
        System.out.println("]");
    }
}