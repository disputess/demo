import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirTwo{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void add() {
        lock.lock();
        try {
             while (number!=0){
                 condition.await();
             }
             number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void notAdd() {
        lock.lock();
        try {
            while (number==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class ThreadLockDemo {
    public static void main(String[] args) {
        AirTwo airTwo = new AirTwo();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                airTwo.add();
            }
        },"A").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                airTwo.notAdd();

            }
        },"B").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                airTwo.add();
            }
        },"C").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                airTwo.notAdd();
            }
        },"D").start();

    }
}
