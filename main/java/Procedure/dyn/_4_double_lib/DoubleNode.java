package Procedure.dyn._4_double_lib;

class DoubleNode {

   public int value;
   public DoubleNode prev;
   public DoubleNode next;

   public DoubleNode(int value, DoubleNode prev, DoubleNode next){
       this.value = value;
       this.prev = prev;
       this.next = next;
   }

    @Override
    public String toString() {
        DoubleNode node = this;
        String result = "";
        while (node != null) {
            result += node.value + "->";
            node = node.next;
        }
        return result + "*";
    }

    public static DoubleNode add(DoubleNode tail, int elem) {
        if (tail==null) throw  new NullPointerException("null parameter passed to a method");
        DoubleNode startOfDoubleNode = tail;
        while (tail.next!=null){
            tail=tail.next;
        }
        tail.next= new DoubleNode(elem,tail,null);
        return startOfDoubleNode;
    }

    public static DoubleNode remove(DoubleNode tail) {
        if (tail==null) throw  new NullPointerException("null parameter passed to a method");

        DoubleNode startOfDoubleNode = tail;

        while (tail.next.next!=null){
            tail=tail.next;
        }
        tail.next=null;
        return startOfDoubleNode;
    }

    public static DoubleNode addInPosition(DoubleNode tail, int index, int elem) {
        if (index <= 0) throw new IllegalArgumentException("index must be positive");
        if (tail==null) throw  new NullPointerException("null parameter passed to a method");

        // if we want element to be the first one
        if (index==1) {
            DoubleNode newValue= new DoubleNode(elem,null,tail);
            tail.prev=newValue;
            return newValue;
        }
        else{
            DoubleNode startOfDoubleNode = tail;
            // if we add element between the others
            while (--index > 1 && tail.next!=null ){
                tail=tail.next;
            }

            if (index>1 && tail.next==null) throw  new NoSuchPositionException("size of DoubleNode is less then passed index");

            DoubleNode newValue = new DoubleNode(elem,tail, tail.next);
            //left node now references to newValue
            tail.next= newValue;
            //if added element is NOT the last one then
            //right node references to newValue by tail.prev
            tail=tail.next.next;
            if (tail!=null) tail.prev= newValue;

            return startOfDoubleNode;
        }
    }

    public static DoubleNode removeFromPosition(DoubleNode tail, int index) {
        if (index < 0) throw new IllegalArgumentException("index must be positive");
        if (tail==null) throw  new NullPointerException("null parameter passed to a method");

        // if we removing the first one
        if (tail.prev==null && index==1) {
            return tail.next;
        }

        DoubleNode startOfDoubleNode = tail;

        while (--index > 1 && tail.next.next!=null){
            tail=tail.next;
        }

        if (index>1 && tail.next.next==null) throw new NoSuchPositionException("size of DoubleNode is less then passed index");

        //if we removing the last one
        if (tail.next.next == null){
            tail.next=null;
        } else {
            // if we removing between the nodes
            tail.next=tail.next.next;
            tail.next.prev=tail;
        }
        return startOfDoubleNode;
    }
}
