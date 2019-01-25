import java.util.Map;

/**
 * Created by chenchangxing on 2019/1/25.
 */
public class ReverseBits {
    public static int reverseBits(int n) {
        String a = Integer.toBinaryString(n);

        String b = "";
        for (int i = 0; i < 32 - a.length(); i++) {
            b += "0";
        }

        a = b + a;

        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result += Math.pow(2, i)  * Integer.parseInt("" + a.charAt(i));
        }
        return result;
    }

    public static int reverseBits1(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
            int temp = n & 0x01;
            n = n >> 1;

            result = (result << 1) | temp;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits1(0xfffffffd));
    }
}
