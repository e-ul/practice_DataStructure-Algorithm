// 02 - Quiz11
public class YMD {
    int y;
    int m;
    int d;

    YMD(int y, int m, int d){
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public static void main(String[] args){

        YMD ymd = new YMD(1996,1,1);
        ymd.before(1);

        System.out.println("y : " + ymd.y);
        System.out.println("m : " + ymd.m);
        System.out.println("d : " + ymd.d);
    }

    YMD after(int n){
        int[][] mdays = {
                {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };

        int days = dayOfYear2(this.y, this.m, this.d) + n;

        int bLeap = isLeap(this.y);
        if(bLeap == 1){
            while (days > 366) {
                this.y++;
                days -= 366;
            }
            bLeap = isLeap(this.y);

        } else {
            while (days > 365) {
                this.y++;
                days -= 365;
            }
            bLeap = isLeap(this.y);
        }

        int i;
        for(i = 0 ; days > mdays[bLeap][i] ; i++){
            days -= mdays[bLeap][i];
        }
        this.m = i + 1;
        this.d = days;

        return this;
    }

    YMD before(int n){
        int[][] mdays = {
                {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };

        int days = dayOfYear2(this.y, this.m, this.d) - n;

        int bLeap = isLeap(this.y - 1);
        if(bLeap == 1){
            while (days <= 0) {
                this.y--;
                days += 366;
            }
            bLeap = isLeap(this.y);

        } else {
            while (days <= 0) {
                this.y--;
                days += 365;
            }
            bLeap = isLeap(this.y);
        }

        int i;
        for(i = 0 ; days > mdays[bLeap][i] ; i++){
            days -= mdays[bLeap][i];
        }
        this.m = i + 1;
        this.d = days;

        return this;
    }

    private static int dayOfYear2(int y, int m, int d) {

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

    private static int isLeap(int y) {
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) ? 1 : 0;
    }

}