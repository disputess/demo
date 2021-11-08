package com.example.web.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 线程操作的资源类：Ticket
//implements  Runnable
class Ticket {
    int number = 30;
    // wai liu tai o 的可见性
    volatile int number1 = 0;
    public void add(){
        this.number = 60;
    }

    public void addPlus(){
        number1++;
    }
    private Lock lock = new ReentrantLock();
    public void saleTicket(){
      /*  lock.lock();
        try{
            if(number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第:"+(number--)+"\t还剩下:"+number);
            }
        }catch(Exception e){
         e.printStackTrace();
        }finally {
        lock.unlock();
        }*/
        System.out.println(Thread.currentThread().getName()+"\t卖出第:"+(number--)+"\t还剩下:"+number);
        number1++;
        number++;
    }
    /*@Override
    public  void run(){

    }*/
}

/**
 * 三个售票员 卖出 30张票
 * 多线程编程的企业级套路+模板
 *  1.在高内聚低耦合的前提下，线程   操作(对外暴露的调用方法)   资源类
 */
public class SaleTicket {
    public static void main(String [] args) throws  Exception // main 一切程序入口
    {
        // 线程操作资源类
        Ticket ticket = new Ticket();
        // new 线程
        new Thread(()->{for(int i =1;i<=40;i++)ticket.saleTicket();},"A").start();
        new Thread(()->{for(int i =1;i<=40;i++)ticket.saleTicket();},"B").start();
        new Thread(()->{for(int i =1;i<=40;i++)ticket.saleTicket();},"C").start();

          //Thread t = new Thread();
          // new Thread(Runnable targe,String name )
       /* new Thread(new Runnable() {
            @Override
            public void run() {
               for(int i =1;i<=40;i++){
                   ticket.saleTicket();
               }
            }
        },"A").start(); // .start()代表已经就绪等待运行

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i <= 40; i++){
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =1;i<=40;i++){
                    ticket.saleTicket();
                }
            }
        },"C").start();
*/
    }
}
