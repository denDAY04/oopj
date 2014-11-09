package SQLDatabase.Threads;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadServer {

    private static final boolean DEBUG = false; //      
   
    
    /** 
     * Parses a database request to the next available worker thread <br>
     * <br>
     * Action: valid input values are "query" or "update"<br>
     * Query : Query string from SQLLibrary.java<br>
     * Values: ArrayList contains values for the Query string<br>
     * <br>
     * The function returns a boolean true for success of operation<br>
     * <br>
     * @param Action
     * @param Query
     * @param Values
     * @return
     */
        public static boolean nextThread(String Action, String Query, ArrayList Values) {
        boolean status = false;
        
        // daemon.executeUpdate(Query, Values)
        
        if (DEBUG) {System.out.println("Test output Action: " + Action);}
        if (DEBUG) {System.out.println("Test output Query: " + Query);}
               
        
        ////////////////  Test  //////////////// 
        
//              ExecutorService executorService = Executors.newFixedThreadPool(10);
////
//WorkerThread workerThread = new WorkerThread();
////MyDataLoader myDataLoader2 = new MyDataLoader("c:/file2");
////MyDataLoader myDataLoader3 = new MyDataLoader("c:/file3");
////
//executorService.execute(workerThread);
//        ResultSet executeUpdate = workerThread.executeUpdate(Action, Query, Values);
//        
////executorService.execute(myDataLoader2);
////executorService.execute(myDataLoader3);
////
////executorService.shutdown();
//        
//        
//        
////        ExecutorService es = Executors.newCachedThreadPool();
////        es.execute(new WorkerThread(Action, Query, Values));
//        
        
        WorkerThread workerThread = new WorkerThread();        
        ResultSet executeUpdate = workerThread.executeUpdate(Action, Query, Values);
        workerThread.run();
            System.out.println(executeUpdate.toString());
        
        
        
        
        
        
        
        
        
//        WorkerThread workerthread = new WorkerThread();
//        boolean threadStatus = workerthread.isAlive();
        
//        ResultSet resultset = workerthread.executeUpdate(Action, Query, Values);  
        
//            System.out.println(resultset.toString());

        return status;
    }

//    private class WorkerThread extends Thread {   //implements Runnable 
//
//        // check connection -- internal database connection check
//        // if connection is alive proceed, else create new connection
//        // execute recieved string literal -- if database is busy then waite 2 seconds and retry (repeat attempt 5 times before terminating)
//        // if return value exists ... return responce value
//        // else return Thread to thread pool
//        @Override
//        public void run() {
//
//        }
//
//    }

    
    

}



















 //   private static final int SIZE_OF_POOL = 20; // fixed size 
//    private static final int TIME_TO_LIVE = 2000; // time in msec
//
// 
//    
////       private void init() {
//////      // SpawnThreadPool(SIZE_OF_POOL);    
////     while (SIZE_OF_POOL - 1 != 0){
////               //WorkerThread daemon = new WorkerThread();
////               // daemon.start();
////               // daemon.addToPool
////        }
////       }