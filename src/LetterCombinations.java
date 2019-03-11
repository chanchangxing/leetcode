import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/11.
 */
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        String[] words = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<char[]> presses = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String b = words[Integer.parseInt(digits.substring(i, i + 1)) - 2];
            presses.add(b.toCharArray());
        }

        List<String> result = new ArrayList<>();
        a(presses, 0, "", result);

        return result;
    }

    public static void a(List<char[]> presses, int pressesIndex, String a,  List<String> result) {
        if (pressesIndex == presses.size()) {
            result.add(a);
            return;
        }

        for (int i = 0; i < presses.get(pressesIndex).length; i++) {
            a(presses, pressesIndex + 1, a + presses.get(pressesIndex)[i], result);
        }
    }

    String[] list = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> output = new ArrayList<>();
    public List<String> letterCombinations1(String digits) {
        if (digits.length() != 0)
            backTrack("", digits);
        return output;
    }

    public void backTrack (String combination, String nextDigits){
        if (nextDigits.length() == 0){
            output.add(combination);
        }else{
            String digit = nextDigits.substring(0,1);
            int num = Integer.parseInt(digit);
            String letters = list[num-2];
            for(int i = 0; i < letters.length(); i++){
                String letter = letters.substring(i,i+1);
                backTrack(combination+letter,nextDigits.substring(1));
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations1("23").toString());
    }
}
