package work;

/**
 * @author ruler
 */
public class Gun {
    public static final int MAX = 20;

    private Integer bullet ;

    public Gun(Integer bullet) {
        this.bullet = bullet;
    }

    public Integer getBullet() {
        return bullet;
    }

    public void setBullet(Integer bullet) {
        this.bullet = bullet;
    }

    /**
     * 射击
     */
    public synchronized void shooting(){
        while(bullet <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.bullet = this.bullet - 1;
        System.out.println("进行射击，子弹数量变成："+bullet);
        notifyAll();
    }

    /**
     * 上膛
     */
    public synchronized  void  loading(){
        while(bullet >= MAX){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.bullet = this.bullet + 1;
        System.out.println("进行上膛，子弹数量变成："+bullet);
        notifyAll();
    }
}
