import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class MergeSort {
    static int[] buff; // 작업용 배열

    public static void main(String[] args) {
//        int[] x = {22,5,11,32,120,68,70};
//        mergeSort(x, 7);
//        sortCalendar();

        PhyscExamSort.PhyscData[] x = {
                new PhyscExamSort.PhyscData("이제노", 178, 0.3),
                new PhyscExamSort.PhyscData("서영호", 187, 1.2),
                new PhyscExamSort.PhyscData("박지성", 180, 0.8),
                new PhyscExamSort.PhyscData("김도영", 178, 1.0),
                new PhyscExamSort.PhyscData("이태용", 173, 1.0),
        };

//        Arrays.sort(x, PhyscExamSort.PhyscData.HEIGHT_ORDER);

        Arrays.sort(x, PhyscExamSort.PhyscData.VISION_ORDER_DESCENDING);

        for(int i = 0 ; i < x.length ; i++) {
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
    }
    static void mergeSort(int[] a, int n) {
        buff = new int[n];

        __mergeSort(a, 0, n-1);
        buff = null;
    }

    static void __mergeSort(int[]a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right)/2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(a, left, center); // 배열의 앞부분을 병합정렬
            __mergeSort(a, center + 1, right); // 배열의 뒷부분을 병합정렬

            for(i = left; i <= center ; i++){
                buff[p++] = a[i];
            }

            while (i <= right && j < p) {
                a[k++] = (buff[j] < a[i]) ? buff[j++] : a[i++];
            }

            while ( j < p ){
                a[k++] = buff[j++];
            }
        }
    }

    static void sortCalendar() {
        GregorianCalendar[] x = {
                new GregorianCalendar(2002, Calendar.FEBRUARY, 5),
                new GregorianCalendar(1993, Calendar.APRIL, 21),
                new GregorianCalendar(1963, Calendar.DECEMBER, 6)
        };

        Arrays.sort(x);

        for(int i = 0 ; i < x.length ; i++) {
            System.out.printf("%04d년 %02d월 %02d일\n",
                x[i].get(Calendar.YEAR),
                x[i].get(Calendar.MONTH)+1,
                x[i].get(Calendar.DATE)
            );
        }
    }

    static class PhyscExamSort {
        static class PhyscData {
            String name;
            int height;
            double vision;

            PhyscData(String name, int height, double vision) {
                this.name = name;
                this.height = height;
                this.vision = vision;
            }

            public String toString() {
                return name + " " + height + " " + vision;
            }

            static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
            static final Comparator<PhyscData> VISION_ORDER_DESCENDING = new VisionDescendingOrderComparator();

            private static class HeightOrderComparator implements Comparator<PhyscData> {
                public int compare(PhyscData d1, PhyscData d2) {
                    return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
                }
            }

            private static class VisionDescendingOrderComparator implements Comparator<PhyscData> {
                public int compare(PhyscData d1, PhyscData d2) {
                    return (d1.vision > d2.vision) ? -1 : (d1.vision < d2.vision) ? 1 : 0;
                }
            }
        }
    }
}
