package recursion;

/**
 * Created by asus on 2020/2/16.
 */
public class RecursionTest {
    public static void main(String[] args) {

        System.out.println();
        test(4);
        test2(4);
    }

    public static void test(int n) {

        if(n>2)
        {
            test(n-1);
        }
        System.out.println("test:n="+n);
    }

    public static void test2(int n) {

        if(n>2)
        {
            test2(n-1);
        }else {
            System.out.println("test2:n=" + n);
        }
    }
}
