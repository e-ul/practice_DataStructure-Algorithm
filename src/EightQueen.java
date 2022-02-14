public class EightQueen {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15]; // / 방향 Queen 배치 Check
    static boolean[] flag_c = new boolean[15]; // \ 방향 Queen 배치 Check
    static int[] pos = new int[8];

    public static void main(String[] args) {
        set(0);
    }

    static void set(int i){
        for(int j = 0 ; j < 8 ; j++){
            if (flag_a[j] == false && flag_b[i+j] == false && flag_c[i-j+7] == false) {
                pos[i] = j;
                if(i==7){
                    print();
                } else {
                    flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;
                }
            }
        }
    }


    static void print() {
        for(int i = 0 ; i < 8 ; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }


    /* 대각선 조건이 없으므로 8개의 서로 잡을 수 없는 Rook 배치와 같음
    static void setRook(int i) {
        for(int j = 0 ; j < 8 ; j++){
            if (flag[j] == false) {
                pos[i] = j;
                if(i==7){
                    print();
                } else {
                    flag[j] = true;
                    setRook(i + 1);
                    flag[j] = false;
                }
            }
        }
    }
    */
}
