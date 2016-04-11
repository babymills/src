package Collections._2_iterator._2_merge;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test_0_1_B {

    public static void main(String[] args) {
        List<Integer> list0 = Collections.<Integer>emptyList();
        List<Integer> list1 = Collections.<Integer>singletonList(10);
        Iterator<Integer> merge = new MergeIterator(list0.iterator(), list1.iterator());

        Utils.checkHasNextTrue(merge, 3);
        if (merge.next() != 10) {
            throw new AssertionError();
        }
        Utils.checkHasNextFalse(merge, 3);

        Utils.checkNextThrow(merge);
        Utils.checkRemoveThrow(merge);

        System.out.print("OK");
    }
}
