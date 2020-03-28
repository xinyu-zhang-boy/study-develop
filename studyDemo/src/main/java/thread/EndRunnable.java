package thread;

/**
 * @author ruler
 */
public class EndRunnable {
    private static class  UserThread implements Runnable{
        @Override
        public void run(){
            System.out.println("thread interrrupted:"+Thread.currentThread().isInterrupted());
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("thread name "+Thread.currentThread().getName()+" is run");
            }
            System.out.println("thread interrrupted:"+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
       UserThread userThread = new UserThread();
       Thread thread =  new Thread(userThread,"userRunnable");
       thread.start();
       Thread.sleep(20);
       thread.interrupt();
    }
}
