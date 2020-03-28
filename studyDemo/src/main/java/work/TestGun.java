package work;

/**
 * @author ruler
 */
public class TestGun {
    /**
     *
     */
    private static class DoShooting implements Runnable{
        private Gun gun;

        public DoShooting(Gun gun) {
            this.gun = gun;
        }

        @Override
        public void run() {
            while(gun.getBullet() > -1){
                gun.shooting();
            }
        }
    }
    private static class DoLoading implements Runnable{
        public static final int MAX = 21;
        private Gun gun;

        public DoLoading(Gun gun) {
            this.gun = gun;
        }

        @Override
        public void run() {
            while(gun.getBullet() < MAX){
                gun.loading();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Gun gun = new Gun(0);
        Thread thread1 = new Thread(new DoLoading(gun));
        Thread thread2 = new Thread(new DoShooting(gun));
        thread1.start();
        thread2.start();
        Thread.sleep(500);
    }
}
