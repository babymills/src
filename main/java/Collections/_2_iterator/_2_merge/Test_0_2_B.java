package Collections._2_iterator._2_merge;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test_0_2_B {

    public static void main(String[] args) {
        List<Integer> list0 = Collections.<Integer>emptyList();
        List<Integer> list1 = Arrays.asList(10, 20);
        Iterator<Integer> merge = new MergeIterator(list0.iterator(), list1.iterator());

        Utils.checkHasNextTrue(merge, 3);
        Utils.checkEquals(merge.next(), 10);
        Utils.checkHasNextTrue(merge, 3);
        Utils.checkEquals(merge.next(), 20);
        Utils.checkHasNextFalse(merge, 3);

        Utils.checkNextThrow(merge);
        Utils.checkRemoveThrow(merge);

        System.out.print("OK");
    }
}
