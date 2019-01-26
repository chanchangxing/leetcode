/**
 * Created by chenchangxing on 2019/1/25.
 */
public class RetrofitTest {
    public static class Test {

    }

    public static void main(String[] args) {
        Test test = new Test();
        Test1 test1 = new Test1();

        System.out.println("1: " + test);
        System.out.println("2: " + test1);

        System.out.println("-----------------------");
        Test test2 = new Test();
        Test1 test11 = new Test1();

        System.out.println("1: " + test2);
        System.out.println("2: " + test11);

    }
}

class Test1 {

}