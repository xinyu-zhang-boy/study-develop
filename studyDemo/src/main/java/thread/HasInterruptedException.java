package thread;

/**
 * @author ruler
 */
public class HasInterruptedException {
    private static class UserThread extends  Thread{
        public UserThread(String name){
            super(name);
        }
        @Override
        public void run(){
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " thread interrupted:" +
                            isInterrupted());
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName+" thread interrupted:"+
                    isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new UserThread("ruler");
        userThread.start();
        Thread.sleep(20);
        userThread.interrupt();
    }
}
