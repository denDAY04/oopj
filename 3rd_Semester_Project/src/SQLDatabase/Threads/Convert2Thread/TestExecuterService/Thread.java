package SQLDatabase.Threads.Convert2Thread.TestExecuterService;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.MediaSize;

//MediaSize.ISO.A4
public class Thread implements Runnable {

    @Override
    public void run() {

        for (int x = 10; x != 0; x--) {

            System.out.println("Thread " + Thread.class.getName() + " says hi");
            try {
                //wait();
                java.lang.Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
