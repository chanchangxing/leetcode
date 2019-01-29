import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by chenchangxing on 2019/1/28.
 */
public class IsValid {
    public static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        Stack<Character> linkedList = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                linkedList.push(s.charAt(i));
                continue;
            }

            if (linkedList.size() == 0) {
                return false;
            }
            if (!pair(linkedList.pop(), s.charAt(i))) {
                return false;
            }
        }

        return linkedList.size() == 0;
    }

    static boolean pair(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }

        if (a == '{' && b == '}') {
            return true;
        }

        if (a == '[' && b == ']') {
            return true;
        }

        return false;
    }

    public boolean isValid1(String s) {
        if(s == null || s.length() == 1) return false;
        if(s.length() == 0) return true;
        char[] arr = s.toCharArray();
        if (arr[0] == ')' || arr[0] == ']' || arr[0] == '}') return false;
        int[] stack = new int[arr.length+1];
        int ptr = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = 0;
            switch(arr[i]){
                case '(':val = -1;break;
                case ')':val = 1;break;
                case '[':val = -2;break;
                case ']':val = 2;break;
                case '{':val = -3;break;
                case '}':val = 3;break;
                default:break;
            }
            if(stack[ptr] + val == 0){
                stack[ptr--] = 0;
            }else{
                stack[++ptr] = val;
            }
        }
        return stack[1] == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
