package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Test_trimToSize {
    public static void main(String[] args) {
        ArrayList<Integer> AL= new ArrayList<>(1_000);
        Random r = new Random();

        // fill
        for (int i=0;i < 1_000_000;i++){
            AL.add(i, r.nextInt(1000));
        }

        System.out.println(AL.size());

        long t0=System.nanoTime();
        for (int j=400_000;j<600_000;j++){
            AL.remove(j);
        }
        long t1=System.nanoTime();

        System.out.println("remove works: " + (t1-t0)/1_000_000_000 + " seconds");

        System.out.println("element of index 500k " +AL.get(500_000));
       /* System.out.println(AL.get(1_000_000-1));   //IndexOutOfBoundsException */

        System.out.println(AL.size());

        AL.trimToSize();

        System.out.println(AL.size());

        /*При удалении произвольного элемента из списка, все элементы находящиеся «правее»
         смещаются на одну ячейку влево и реальный размер массива (его емкость, capacity)
         не изменяется никак. Механизм автоматического «расширения» массива существует, а
         вот автоматического «сжатия» нет, можно только явно выполнить «сжатие» командой trimToSize().*/
    }
}
