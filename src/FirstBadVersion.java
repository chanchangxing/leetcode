import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Created by chenchangxing on 2019/1/7.
 */
public class FirstBadVersion {
    static boolean isBadVersion(int version) {
        System.out.println("hahah");
        return version >= 4;
    }

    static int firstBadVersion(int n) {
        int l = 1, h = n;         //l---低位   h---高位
        while (l < h) {
            int mid = l + (h - l) / 2;      //(1)
            if (isBadVersion(mid))
                h = mid;                    //(2)
            else
                l = mid + 1;                //(3)
        }
        return h;
    }

    public static void main(String[] args) {
        firstBadVersion(5);
    }
}
