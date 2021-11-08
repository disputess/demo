import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource
{
    private int number = 1; //1:A 2:B 3:C
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            // 判断
           while (number !=1){
               condition1.await();
           }
           // 干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            // 通知
            number =2 ;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            // 判断
            while (number !=2){
                condition2.await();
            }
            // 干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            // 通知
            number =3 ;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            // 判断
            while (number !=3){
                condition3.await();
            }
            // 干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            // 通知
            number =1 ;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 多线程之间按顺序调用 实现A->B->C
 * AA打印5次BB打印10次CC打印十五次
 * 再AA打印5次BB打印10次CC打印十五次
 * 来十轮
 * 1高内聚低耦合 线程操作资源类
 * 2 判断 操作(干活) 通知
 * 3 多线程交互中，必须要防止多线程的虚假唤醒，也即多线程的判断(只能用while,不能用if)
 * 4 标志位
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}
