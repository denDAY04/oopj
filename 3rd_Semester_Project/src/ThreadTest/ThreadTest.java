package ThreadTest;


public class ThreadTest 
{   
    public static void main(String[] args) 
    {
        
        MyThreadClassA ITCA = new MyThreadClassA();
        MyThreadClassB ITCB = new MyThreadClassB();
        ITCA.start();
        ITCB.start(); 
     // ITCB.run();
    }
     
}
