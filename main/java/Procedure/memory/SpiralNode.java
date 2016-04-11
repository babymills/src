package Procedure.memory;

public class SpiralNode {
    public int value;
    public SpiralNode next;
    public SpiralNode bottom;

    public SpiralNode(int value, SpiralNode next, SpiralNode bottom) {
        this.value = value;
        this.next = next;
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        return "{" + value + " " + ((next == null) ? "*" : next.value) + " " + ((bottom == null) ? "*" : bottom.value) + '}';
    }
}
