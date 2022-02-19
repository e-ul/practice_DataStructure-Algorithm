public class BubbleSort {
    public static void main(String[] args) {
        int[] x = {22,5,11,32,120,68,70};
//        bubbleSort(x, 7);
//        bubbleSortReverse(x, 7);
//        bubbleSort_v2(x, 7);
//        bubbleSort_v3(x, 7);
        bubbleSort_v4(x, 7);
    }

    static void bubbleSort(int[] a, int n) {
        for(int i = 0 ; i < n - 1 ; i++) {
            for(int j = n - 1 ; j > i ; j--) {
                if(a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                }
            }
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 06 - Q1
    static void bubbleSortReverse(int[] a, int n) {
        for(int i = n-1 ; i > 0 ; i--) {
            for(int j = 0 ; j < i ; j++) {
                if(a[j] > a[j + 1]){
                    swap(a, j, j+1);
                }
            }
        }
    }

    static void bubbleSort_v2(int[] a, int n) {
        for(int i = 0 ; i < n - 1 ; i++) {
            int exchgcnt = 0;
            for(int j = n - 1 ; j > i ; j--) {
                if(a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    exchgcnt++;
                }
            }
            if(exchgcnt == 0) {
                break;
            }
        }
    }

    static void bubbleSort_v3(int[] a, int n) {
        int k = 0;
        while (k < n - 1) {
            int last = n - 1;
            for(int j = n - 1 ; j > k ; j--) {
                if(a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    // 06 - Q5 : 양방향 버블정렬 해보기
    static void bubbleSort_v4(int[] a, int n) {
        int k_odd = 0;
        int k_even = n-1;
        int last = k_even;

        while (k_odd < k_even) {
            for(int j = k_even ; j > k_odd ; j--) {
                if(a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            k_odd = last;

            for(int j = k_odd ; j < k_even ; j++) {
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                    last = j;
                }
            }
            k_even = last;
        }
    }
}
