import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone{
    private static  Lock lock = new ReentrantLock();
       public  synchronized void sendEm(){
           //lock.lock();
           try {
               lock.lock();
               lock.lock();
               TimeUnit.SECONDS.sleep(4);
               System.out.println(Thread.currentThread().getName()+"\t"+"sendEm---------");
           } catch (Exception e) {
               e.printStackTrace();
           }finally {
              // lock.unlock();
           }
       }
    public static synchronized  void sendMs(){
        //lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"sendMs---------");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
          //  lock.unlock();
        }
    }
    public  void hello(){
        System.out.println(Thread.currentThread().getName()+"\t"+"hello---------");

    }
}

/**
 * 题目：多线程8锁
 * 1.标准访问 先打印 sendEm 还是 sendMs
 * 2.邮件方法暂停四秒 先打印 sendEm 还是 sendMs
 * 3.新增一个普通方法hello() 先打印 sendEm 还是 hello
 * 4.两部手机 先打印 sendEm 还是 sendMs
 * 5.两个静态同步方法 一部手机 先打印 sendEm 还是 sendMs
 * 6.两个静态同步方法 2部手机 先打印 sendEm 还是 sendMs
 * 7.一个普通同步方法，一个静态同步方法 1部手机 先打印 sendEm 还是 sendMs
 * 8.一个普通同步方法，一个静态同步方法 2部手机 先打印 sendEm 还是 sendMs
 *
 * 一个资源类里有多个synchronized方法，同一时间段只有一个线程能访问这个资源类的synchronized方法
 */
public class Lock8 {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{phone1.sendEm();},"A").start();
        new Thread(()->{
            //phone.sendMs();
            //phone.hello();
            phone2.sendMs();
            },"B").start();
    }

}
