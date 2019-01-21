import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenchangxing on 2019/1/21.
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); ) {
            if (i < s.length() - 1) {
                switch (chars[i]) {
                    case 'I':
                        if (chars[i + 1] == 'V') {
                            count += 4;
                            i += 2;
                            break;
                        }
                        if (chars[i + 1] == 'X') {
                            count += 9;
                            i += 2;
                            break;
                        }

                        count += 1;
                        i += 1;
                        break;
                    case 'V': {
                        count += 5;
                        i += 1;
                        break;
                    }
                    case 'X': {
                        if (chars[i + 1] == 'L') {
                            count += 40;
                            i += 2;
                            break;
                        }

                        if (chars[i + 1] == 'C') {
                            count += 90;
                            i += 2;
                            break;
                        }

                        count += 10;
                        i++;
                        break;
                    }
                    case 'L': {
                        count += 50;
                        i++;
                        break;
                    }
                    case 'C': {
                        if (chars[i + 1] == 'D') {
                            count += 400;
                            i += 2;
                            break;
                        }

                        if (chars[i + 1] == 'M') {
                            count += 900;
                            i += 2;
                            break;
                        }

                        count += 100;
                        i++;
                        break;
                    }
                    case 'D': {
                        count += 500;
                        i++;
                        break;
                    }

                    case 'M': {
                        count += 1000;
                        i++;
                        break;
                    }
                }
            }

            if (i == s.length() - 1) {
                switch (chars[i]) {
                    case 'I': count += 1;return count;
                    case 'V': count += 5;return count;
                    case 'X': count += 10;return count;
                    case 'L': count += 50;return count;
                    case 'C': count += 100;return count;
                    case 'D': count += 500;return count;
                    case 'M': count += 1000;return count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(romanToInt("IV"));
    }
}
