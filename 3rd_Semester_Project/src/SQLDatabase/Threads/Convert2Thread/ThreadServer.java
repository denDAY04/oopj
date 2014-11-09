package SQLDatabase.Threads.Convert2Thread;

//import java.sql.ResultSet;
import SQLDatabase.Threads.Convert2Thread.WorkerThread;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadServer{

    private static final boolean DEBUG = false;    
     
    
//<editor-fold defaultstate="collapsed" desc="comment">
//    public interface ThreadFactory
//
//    An object that creates new threads on demand. Using thread factories removes hardwiring of calls to new Thread, enabling applications to use special thread subclasses, priorities, etc.
//    The simplest implementation of this interface is just:
//    class SimpleThreadFactory implements ThreadFactory {
//     public Thread newThread(Runnable r) {
//     return new Thread(r);
//   }
// }
//</editor-fold>    
    
     /**
     * Main method starts server. Runs until terminated.
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService es = null; 
        ThreadServer server = null;          
        try {
            server = new ThreadServer(); 
            es = Executors.newCachedThreadPool();        
            server.execute(es);            
        } catch (Exception e) {System.err.println(e);}
        finally {server.shutDown(es);}  
        
    }        
                

    public void shutDown(ExecutorService es) {System.err.println("Closing connection");
        es.shutdown();
        //System.exit(1);
    }
    
    
    
    private void execute(ExecutorService es){
        
          es.execute(new WorkerThread(Con, Action, Query, Parameters));
//        es.executeJob(null, null, port);             
//        es.execute(new JobThread(workerThreadPool, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Long.parseLong(parts[2]), address, port));
   }
    
    
    
    
    
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
               
   
        
        
        return status;
    }
 
        
        
        
        
        
}


        
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
        
   
        
//          private WorkerThread workerThread = new WorkerThread();        
//        
//    
//    ResultSet executeUpdate = workerThread.executeUpdate(Action, Query, Values);
//        workerThread.run();
//            System.out.println(executeUpdate.toString());
        
        
        
        //    private WorkerPool workerThreadPool = new WorkerPool(4, 20, 2000);
//    ExecutorService executor = Executors.newFixedThreadPool(20);
        
        
        
        
        
//        WorkerThread workerthread = new WorkerThread();
//        boolean threadStatus = workerthread.isAlive();
        
//        ResultSet resultset = workerthread.executeUpdate(Action, Query, Values);  
        
//            System.out.println(resultset.toString());


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