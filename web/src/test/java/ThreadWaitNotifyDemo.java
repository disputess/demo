import org.junit.Test;

/*
 *  资源类
 */
class Air{
    private  int number =0;
    public synchronized void add() throws InterruptedException {
        // 判断
        while(number != 0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        // 通知
        this.notifyAll();
    }
    public synchronized void notAdd() throws InterruptedException {
        // 判断
        while(number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        // 通知
        this.notifyAll();
    }
}

/*
 * 题目：现在两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1一个线程对该变量减1
 * 实现交替 来十轮 变量初始值为0
 *  1高内聚低耦合 线程操作资源类
 *  2 判断 操作(干活) 通知
 *  3 多线程交互中，必须要防止多线程的虚假唤醒，也即多线程的判断(只能用while,不能用if)
 */
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        Air air = new Air();
        new Thread( ()->{
            for (int i =1;i<=10;i++){
                try {
                    air.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread( ()->{
            for (int i =1;i<=10;i++){
                try {
                    air.notAdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread( ()->{
            for (int i =1;i<=10;i++){
                try {
                    //Thread.sleep(400);
                    air.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread( ()->{
            for (int i =1;i<=10;i++){
                try {
                   // Thread.sleep(500);
                    air.notAdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}
