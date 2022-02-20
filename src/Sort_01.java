public class Sort_01 {
    public static void main(String[] args){
        int[] x = {22,5,11,32,120,68,70};
//        selectionSort(x, 7);
//        insertionSort(x, 7);
        shellSort(x, 7);
    }

    static void selectionSort(int[] a, int n) {
        for(int i = 0 ; i < n ; i++){
            int minIdx = i;
            for(int j = i + 1 ; j < n ; j++){
                if (a[j] < a[minIdx]){
                    minIdx = j;
                }
            }
            swap(a, i, minIdx);
        }
    }

    static void insertionSort(int[] a, int n) {
        for(int i = 1 ; i < n ; i++) {
            int j;
            int tmp = a[i];
            for(j = i; j > 0 && a[j-1] > tmp ; j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    static void shellSort(int[] a, int n) {
        int h;
        for(h=1; h < n/9; h = h*3+1)
            ;

        for(; h > 0 ; h /= 3) {
//        for(int h = n/2 ; h > 0 ; h /= 2) {
            for(int i = h ; i < n ; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }

        for(int k = 0 ; k < a.length ; k++) {
            System.out.print( a[k] + " ");
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
}
