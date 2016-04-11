package Procedure.loop._2_array_merger_fixed_____;

public class Test_0_0 {

    public static void main(String[] args) {
        int[] result = Merger.merge(new int[]{}, new int[]{});

        if (result.length != 0) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
