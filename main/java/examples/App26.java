package examples;

public class App26 extends Y{
    public static void main(String[] args) {
        Parent refP = new Child();
        refP.a1();
        refP.a2();
        Child refC= new Child();
        refC.a1();
        refC.a2();
        refC.a3();
        Parent refP2 = new Parent();
        refP2.a1();
        refP2.a2();
    }
}

abstract class X{}
abstract class Y extends X{}

class Parent{
    public void a1(){
        System.out.println("a1");
    }
    public void a2(){
        System.out.println("a2");
    }
}

class Child extends Parent{
    public void a1(){
        System.out.println("a1");
    }
    public void a2(){
        System.out.println("a2");

    }
    public void a3(){
        System.out.println("a3");
    }
}


