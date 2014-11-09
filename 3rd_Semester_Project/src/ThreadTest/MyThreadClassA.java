package ThreadTest;

class MyThreadClassA extends Thread
    {
        public void run()
        {
            try {          
              System.out.println("Thread A says hello");
            } catch (Exception e) {System.out.println("Thread A says err");
            }            
        }    
    }