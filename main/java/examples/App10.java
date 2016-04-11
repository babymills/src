package examples;

public class App10 {
    public static void main(String[] args){
        int x = 0b11111111_11111111_11111111_11111111 >> 2;
        int y = 0b11111111_11111111_11111111_11111111<<2;
        System.out.println(x);
        System.out.println(y);
        int z = 0b11111111_11111111_11111111_11111111>>1;
        int w = 0b11111111_11111111_11111111_11111111<<1;
        System.out.println(z);
        System.out.println(w);
        char q=0000;
        char r= (char) 007F;
        System.out.println(q+" "+ r);
    }
}