package cn.linguy.student.threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        TestDemo testDemo = new TestDemo();
        for (int i=0;i<10;i++){
            pool.execute(testDemo);
        }

    }

    static class TestDemo implements Runnable{
        private AtomicInteger a = new AtomicInteger(10);
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"-----"+a);
            a.getAndIncrement();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-----"+a);
        }
    }
}
