package examples;

import Procedure.dyn._2_single_lib.Node;
//(byte)  63; /*  63 0x3f 0b00111111 (ignored tag, skip to next byte) */
// (byte)  31; /*  31 0x1f 0b00011111 small negative integer - value in low 4 bits (k+32) */
public class App09_Node {
    public static void main(String[] args){
        Node refA = new Node(3, new Node(4, null));
        refA = new Node(1, new Node(2, refA));
        System.out.println(refA.next.next.next.value);
        refA.next.next.next = refA;
        System.out.println(refA.next.next.next.value);
        Node refB = refA.next.next;
        System.out.println(refB.value);
        System.out.println(refB.next.value);
        System.out.println(refB.next.next.value);
        System.out.println("-----------");
        Node refA1 = new Node(1, new Node(2, null));

        refA1.next.next = refA1;
        System.out.println(refA1.next.next.value);
        System.out.println(refA1.value);
        Node refB1 = new Node(3, refA1.next);
        System.out.println(refA1.next.next.value);
    }
}