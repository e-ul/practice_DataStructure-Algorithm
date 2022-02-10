import java.util.Scanner;

public class exercise_Feb_01 {
    public static void main(String[] args){

        nspira(4);

//        System.out.println("Gaussian Addition Result : " + quiz1_9(6, 6) );
    }

    // gaussianAddition
    static int quiz1_8(int n){
        return (1 + n) * (n/2) + (n % 2 == 0 ? 0 : (n+1) / 2);
    }

    static int quiz1_9(int a, int b){
        if (a > b) {
            return quiz1_8(a) - quiz1_8(b-1);
        } else if ( b > a ){
            return quiz1_8(b) - quiz1_8(a-1);
        } else {
            return 0;
        }
    }

    // 01 - Quiz15
    static void triangleRU(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(j < i){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    // 01 - Quiz15
    static void triangleRB(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if((n-j- 1) > i){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    // 01 - Quiz15
    static void triangleLU(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = n ; j > i ; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 01 - Quiz15
    static void triangleLB(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 01 - Quiz16
    static void spira(int n){
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 2*n - 1 ; j++){
                if(j >= n-i-1 && j <= n+i-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // 01 - Quiz17
    static void nspira(int n){
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 2*n - 1 ; j++){
                if(j >= n-i-1 && j <= n+i-1){
                    System.out.print(i+1);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // median of 3
    static int training1C_1(int a, int b, int c){
        if( a >= b ){
            if ( b >= c ) {
                return b;
            } else if ( a <= c){
                return a;
            } else {
                return c;
            }
        } else if( a > c ){
            return a;
        } else if( b > c ){
            return c;
        } else {
            return b;
        }
    }
}
