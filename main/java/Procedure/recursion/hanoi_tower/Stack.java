package Procedure.recursion.hanoi_tower;

public class Stack {
    private Node top;

    public void push(int value) {
        if (top != null && value > top.value) {
            throw new IllegalStateException("Inverse order: push " + value + " to " + this.toString());
        }
        this.top = new Node(value, top);
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Can't pop - empty stack!:");
        }
        int result = top.value;
        top = top.next;
        return result;
    }

    private static class Node {
        private final int value;
        private final Node next;

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        String result = "top:[";
        Node ref = top;
        while (ref != null) {
            result += ref.value + ((ref.next == null) ? "" : " ");
            ref = ref.next;
        }
        return result + "]";
    }
}
