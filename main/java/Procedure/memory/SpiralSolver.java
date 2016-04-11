package Procedure.memory;

public class SpiralSolver {

    public static SpiralNode make(int len, int count) {
        int num = len;
        SpiralNode tmpHead = new SpiralNode(num--, null, null);
        SpiralNode tmpTail = tmpHead;
        for (int k = 0; k < len; k++) {
            tmpTail = new SpiralNode(num--, tmpTail, null);
        }
        tmpHead.bottom = tmpTail;
        tmpTail.bottom = tmpHead;

        SpiralNode low = tmpTail;
        SpiralNode top = tmpHead;
        num = len;
        for (int k = 1; k < count; k++) {
            for (int index = 0; index < len; index++) {
                SpiralNode node = new SpiralNode(++num, null, null);
                low = low.next;
                low.bottom = node;
                top.next = node;
                top = top.next;
            }
        }

        return tmpTail;
    }
}

