package ThreadTest;

class MyThreadClassB extends Thread
    {
        public void run()
        {
            try {            
              System.out.println("Thread B says hello");
            } catch (Exception e) {System.out.println("Thread B says err");
            }
        }    
    }