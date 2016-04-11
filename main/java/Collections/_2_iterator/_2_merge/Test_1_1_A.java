package Collections._2_iterator._2_merge;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test_1_1_A {

    public static void main(String[] args) {
        List<Integer> list0 = Arrays.asList(10);
        List<Integer> list1 = Arrays.asList(20);
        Iterator<Integer> merge = new MergeIterator(list0.iterator(), list1.iterator());

        Utils.checkEquals(merge.next(), 10);
        Utils.checkEquals(merge.next(), 20);
        Utils.checkHasNextFalse(merge, 3);

        Utils.checkNextThrow(merge);
        Utils.checkRemoveThrow(merge);

        System.out.print("OK");
    }
}
