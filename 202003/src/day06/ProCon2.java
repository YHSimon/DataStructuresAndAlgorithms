package day06;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock实现生产者消费者模式
 */
public class ProCon2 {

    public static void main(String[] args) {
        Data2 data2 = new Data2();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data2.increase();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data2.decrease();
            }
        }, "B").start();
    }

}

class Data2 {
    private Integer num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num++;
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "-->" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "-->" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}