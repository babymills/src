package examples;

public class App11_IntegerShifts {
    public static void main(String[] args){
        Integer i0 = 200;
        Integer i1 = 200;
        System.out.println(i0 == i1);
        int x = (Integer.MIN_VALUE >> 1) << 1;
        System.out.println(x);  //l
        int y = Integer.MIN_VALUE << 1;
        System.out.println(y);  //m
        int z = (Integer.MIN_VALUE >>> 1) << 1;
        System.out.println(z);   //m
    }
}