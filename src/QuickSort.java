public class QuickSort {
    public static void main(String[] args) {

        int[] x = {1,8,7,4,5,2,6,3,9};
//        int[] x = {5,8,4,2,6,1,3,9,7};
//        partition(x, 9);
        quickSort_v2(x, 0, 8);

        for (int k = 0 ; k < x.length ; k++){
            System.out.print(x[k] + " ");
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // non-recursive QuickSort
    static void quickSort_v2(int[] a, int left, int right) {
        IntStack lStack = new IntStack(right - left + 1);
        IntStack rStack = new IntStack(right - left + 1);

        lStack.push(left);
        rStack.push(right);

        while(lStack.isEmpty() != true) {
            int pl = left = lStack.pop();
            int pr = right = rStack.pop();
            int x = a[(left + right)/2];

            do {
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;
                if(pl <= pr){
                    swap(a, pl++, pr--);
                }
            } while(pl <= pr);

            if(left < pr) {
                lStack.push(left);
                rStack.push(pr);
            }
            if(pl < right) {
                lStack.push(pl);
                rStack.push(right);
            }
        }
    }

    // recursive QuickSort
    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                swap(a, pl++, pr--);
            }
        } while(pl <= pr);

        // pivot 이하의 그룹
        System.out.println("pivot 이하의 그룹");
        for (int i = left ; i <= pl - 1 ; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // pivot과 일치하는 그룹
        System.out.println("pivot과 일치하는 그룹");
        for(int i = pr + 1 ; i <= pl - 1 ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // pivot 이상의 그룹
        System.out.println("pivot 이상의 그룹");
        for(int i = pr + 1 ; i < right  ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println();

        if (left < pr) quickSort(a, left, pr);
        if (right > pl) quickSort(a, pl, right);

    }

    static void partition(int[] a, int n) {
        int pl = 0; // left cursor
        int pr = n - 1; // right cursor
        int x = a[n/2];

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while(pl <= pr);

        // pivot 이하의 그룹
        System.out.println("pivot 이하의 그룹");
        for (int i = 0 ; i <= pl - 1 ; i++){
            System.out.print(a[i] + " ");
        }


        // pivot과 일치하는 그룹
        System.out.println("pivot과 일치하는 그룹");
        for(int i = pr + 1 ; i <= pl - 1 ; i++) {
            System.out.print(a[i] + " ");
        }

        // pivot 이상의 그룹
        System.out.println("pivot 이상의 그룹");
        for(int i = pr + 1 ; i < n  ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
