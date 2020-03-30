package day06;

/**
 * synchronized 实现生产者与消费者模式
 */
public class ProCon {
    public static void main(String[] args) {
        Data data=new Data();
        new Thread(()->{
            for(int i=0;i<30;i++){
                data.increase();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                data.decrease();
            }
        },"B").start();
    }
}

class Data {
    private Integer num = 0;

    /**
     * 加一
     */
    public synchronized void increase() {
        try {
            while (num != 0) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        this.notify();
        System.out.println(Thread.currentThread().getName() + "-->" + num);
    }

    public synchronized void decrease() {
        try {
            while (num == 0) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num--;
        this.notify();
        System.out.println(Thread.currentThread().getName()+"-->"+num);
    }
}

