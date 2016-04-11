package Procedure.loop._2_array_merger_fixed_____;

public class Merger {

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while ((aIndex!=a.length) && (b.length!=bIndex)) {
//            if (a[aIndex] < b[bIndex]) {
//                result[aIndex + bIndex] = a[aIndex++];
//            } else {
//                result[aIndex + bIndex] = b[bIndex++];
//            }
            result[aIndex + bIndex]=(a[aIndex] < b[bIndex])? a[aIndex++]:b[bIndex++];
        }
        if (aIndex==a.length) System.arraycopy(b,bIndex,result,aIndex+bIndex,b.length-bIndex);
        else System.arraycopy(a,aIndex,result,aIndex+bIndex,a.length-aIndex);
        return result;
    }
}
