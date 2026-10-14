package minimumAddToMakeParenthesesValid;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else{// ')'
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }

        return stack.size();
    }
}
