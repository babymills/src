package rowset;

import java.util.Random;

/**
 * @author Mark created at: 04.08.2014, 23:45
 */

//
public class Function {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i=0; i<10;i++){
            int k = random.nextInt(10_000);
            System.out.println(k+ " " +function(k));
            System.out.println(i+ " " +function(i));
        }
    }
    public static int function(int n){
        int m=0;
        for (;n>0;n=n/10){
            int k=n%10;
            if (k>m) m=k;
        }
        return m;
    }
}
