public class Recursive_01 {
    public static void main(String[] args){
//        int x = gcd(8, 22);

//        int x = gcd_q2(8, 22);
//        int x = factorial(3);
        int[] a = {108, 690, 72};
        int x = gcdArray(a);
        System.out.println(x);
    }

    // training 5-2
    static int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }
        else {
            return gcd(y, x % y);
        }
    }

    // 05 - Q2
    static int gcd_q2(int x, int y) {

        while ( y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }

        return x;
    }

    static int gcdArray(int[] a) {
        if ( a.length <= 1) {
            return a[0];
        }

        int tmp = gcd(a[0], a[1]);
        for(int i = 2 ; i < a.length ; i++){
            tmp = gcd(tmp, a[i]);
        }
        return tmp;
    }

    // 05 - Q1
    static int factorial(int n) {
        int fac = 1;
        while (n > 1){
            fac *= n;
            n--;
        }
        return fac;
    }

}
