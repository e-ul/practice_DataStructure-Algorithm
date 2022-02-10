public class exercise_Feb_02 {
    public static void main(String[] args){

        int[] a = {1,3,5,7,7,7,7,8,8,9,9};
        int n = binSearchX(a, 11, 7);
        System.out.println("n : " + n);

//        int[] a = {1,9,2,9,4,6,7,9};
//        int[] idx = {0,0,0};
//        int n = searchIdx(a, 8, 9, idx);
//        System.out.println("n : " + n);

//        System.out.println("leftDays : " + leftDayOfYear(1993, 4, 21));
//
//        dayOfYear2(1993, 12, 30);
//
//        primeNumber3(100);

//        char[] cno = new char[32];
//        cardConvR(59, 8, cno);
    }

    // 02 - Quiz5
    static void rcopy(int[] a, int[] b){
        // validation
        if(a.length != b.length){
            //exception occur
        }

        for(int i = 0 ; i < a.length ; i++){
            a[i] = b[b.length - i - 1];
        }

    }

    // training 2-8 A
    static int cardConvR(int x, int r, char[] d) {
        // x를 r진수로 변환하여 배열d에 아랫자리부터 삽입
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // x를 r로 나눈 나머지를 진법문자로 바로 변환하기 위한 kick,,,똑똑해...

        do {
            d[digits++] = dchar.charAt(x%r);
            x = x / r; // x /=r 과 같음
        } while ( x != 0 );

        cardConv(d);

        return digits;
    }

    // 02 - Quiz6
    static char[] cardConv(char[] d){
        int i = 1;
        while (d[d.length - i] != 0 ){
            i++;
        }

        char[] ds = new char[d.length - i];

        for(int j = 0 ; j < ds.length ; j++){
            ds[j] = d[ds.length - j - 1];
            System.out.println("ds[" + j + "] = " + ds[j]);
        }

        return ds;
    }

    // training 2-9
    static void primeNumber1(int n){

        int counter = 0;
        for(int i = 2 ; i <= n ; i++){
            int j;
            for(j = 2 ; j < i ; j++ ){
                counter++;
                if(i % j == 0){
                    break;
                }
            }
            if( j == i ){
                System.out.println(j);
            }
        }

        System.out.println("counter : " + counter);
    }

    // training 2-10
    static void primeNumber2(int n) {
        int counter = 0 ;
        int ptr = 0;
        int[] prime = new int[25];

        prime[ptr++] = 2;

        for(int i = 3 ; i <=n ; i += 2) {
            int j;
            for (j = 1 ; j < ptr ; j++){
                counter++;
                if(i % prime[j] == 0){
                    break;
                }
            }
            if(ptr == j){
                prime[ptr++] = i;
            }
        }

        for(int i = 0 ; i < ptr ; i++){
            System.out.println(prime[i]);
        }

        System.out.println("Counter : " + counter);
    }

    // training 2-11
    static void primeNumber3(int n) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[25];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for(int i = 5 ; i <=n ; i += 2) {
            boolean flag = false;
            for (int j = 0 ; prime[j] * prime[j] <= i ; j++){
                counter += 2;
                if(i % prime[j] == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                counter++;
                prime[ptr++] = i;
            }
        }

        for(int i = 0 ; i < ptr ; i++){
            System.out.println(prime[i]);
        }

        System.out.println("Counter : " + counter);
    }

    // training 2-13
    static int dayOfYear1(int y, int m, int d) {
        int days = d;

        int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
        };

        for(int i = 0 ; i < m - 1; i++){
            days += mdays[isLeap(y)][i];
        }

        System.out.println("days : " + days);

        return days;
    }

    private static int isLeap(int y) {
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) ? 1 : 0;
    }

    // 02 - Quiz8
    static int dayOfYear2(int y, int m, int d) {

        int[][] mdays = {
                {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };

        int n = 0;
        while(n < m-1) {
            d += mdays[isLeap(y)][n];
            n++;
        }

        System.out.println("days : " + d);
        return d;
    }

    // 02 - Quiz9
    static int leftDayOfYear(int y, int m, int d) {
        if(isLeap(y) == 1){
            return 366 - dayOfYear2(y, m, d);
        } else {
            return 365 - dayOfYear2(y, m, d);
        }
    }

    // 03 - Quiz3
    static int searchIdx(int[] a, int n, int key, int[] idx){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(a[i] == key){
                idx[cnt++] = i;
            }
        }

        return cnt;
    }

    // 03 - Quiz5
    static int binSearchX(int[] a, int n, int key){
        int pl = 0;
        int pr = n - 1;

        int p = 0;
        do {
            int pc = (pl + pr) / 2;
            if(a[pc] == key){
                p = pc;
                break;
            } else if (a[pc] < key){
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while( pl <= pr );

        for(int i = p ; i > 0 ; i--){
           if(a[i-1] != a[i]){
               return i;
           }
        }
        return -1;
    }
}





