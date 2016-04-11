package Collections._2_iterator._2_merge;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test_1_0_A {

    public static void main(String[] args) {
        List<Integer> list0 = Collections.<Integer>singletonList(10);
        List<Integer> list1 = Collections.<Integer>emptyList();
        Iterator<Integer> merge = new MergeIterator(list0.iterator(), list1.iterator());

        Utils.checkEquals(merge.next(), 10);
        Utils.checkHasNextFalse(merge, 3);

        Utils.checkNextThrow(merge);
        Utils.checkRemoveThrow(merge);

        System.out.print("OK");
    }
}
