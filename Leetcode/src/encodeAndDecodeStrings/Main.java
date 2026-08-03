package encodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/encode-and-decode-strings
    Array
    String
    Design
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String encoded;

        encoded = solution.encode(List.of("Hello","World"));
        System.out.println(encoded);
        System.out.println(solution.decode(encoded));

    }
}
class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str: strs){
            encoded.append(str.length()).append('#').append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i=0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int strSize = Integer.parseInt(str.substring(i, j));
            decoded.add(str.substring(j+1, j+1+strSize));
            i = j+1+strSize;
        }
        return decoded;
    }
}
