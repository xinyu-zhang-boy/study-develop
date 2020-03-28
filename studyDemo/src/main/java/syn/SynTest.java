package syn;

/**
 * @author ruler
 */
public class SynTest {
    /**
     * 初始化
     */
    private volatile  Long age = Long.valueOf(0);

    public synchronized void count(){
        age++;
    }

    public Long getAge(){
        return this.age;
    }

    public void setAge(Long age){
        this.age = age;
    }

    public static class UserThread extends  Thread{
        private SynTest synTest;
        public UserThread(SynTest sysTest){
            super("user1");
            this.synTest = sysTest;
        }

        @Override
        public void run(){
            for (int i = 0; i < 10000; i++) {
                synTest.count();
            }
            System.out.println(synTest.getAge());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynTest synTest = new SynTest();
        Thread userThread1 = new UserThread(synTest);
        Thread userThread2 = new UserThread(synTest);
        userThread1.start();
        userThread2.start();
        Thread.sleep(20);
        System.out.println("main:"+synTest.getAge());
    }
}
