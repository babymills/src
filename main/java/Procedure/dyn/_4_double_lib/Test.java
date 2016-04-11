package Procedure.dyn._4_double_lib;

//Разработать класс-библиотеку для работы с двусвязными списками. А именно 4 метода из DynamicArray.
//Примечание: теперь надо модифицировать две ссылки, а не одну (как у односвязных списков)

import static Procedure.dyn._4_double_lib.DoubleNode.*;

public class Test {
        public static void main(String[] args) {
       DoubleNode value0= new DoubleNode(0, null, null);
       DoubleNode value1=new DoubleNode(1,value0,null);
       DoubleNode value2=new DoubleNode(2,value1,null);
       DoubleNode value3=new DoubleNode(3,value2,null);

        value0.next= value1;
        value1.next=value2;
        value2.next=value3;

        value1.prev=value0;
        value2.prev=value1;
        value3.prev=value2;

        System.out.println("original: " + value0.toString());
        DoubleNode resAfterAddLast = add(value0, 4);
        System.out.println("addLast: " + resAfterAddLast.toString());
        DoubleNode resultAfterRemoveLast = remove(resAfterAddLast);
        System.out.println("removeLast: " + resultAfterRemoveLast.toString());

        int position = 5;

        System.out.println("position: "+position);
        DoubleNode resultAfterAdding = addInPosition(value0, position, 4);
        System.out.println("addInPosition: " + resultAfterAdding.toString());
        DoubleNode resultAfterDeleting = removeFromPosition(resultAfterAdding, position);
        System.out.println("removeFromPosition: " + resultAfterDeleting.toString());
    }
}

