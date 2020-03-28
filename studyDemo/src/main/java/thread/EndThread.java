package thread;

/**
 * @author ruler
 */
public class EndThread {
    private static class UserThread extends  Thread{
        public UserThread(String name){
            super(name);
        }
        @Override
        public void run(){
            System.out.println("threadName interrupted:"+isInterrupted());
            while(!isInterrupted()){
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+"is run");
            }
            System.out.println("threadName interrupted:"+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new UserThread("ruler");
        userThread.start();
        Thread.sleep(20);
        userThread.interrupt();
    }
}
