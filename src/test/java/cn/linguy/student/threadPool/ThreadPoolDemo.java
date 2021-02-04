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
        String a = "redis 缓存雪崩\n" +
                "大量缓存数据不可用\n" +
                "redis 缓存穿刺\n" +
                "大量无用数据 被进行查询\n" +
                "cas\n" +
                "atomic原子类\n" +
                "es写入  取出  倒排索引  \n" +
                "mongoDb  字段类型没有约束  更适合存储 json数据类型  评论,点赞之类的\n" +
                "java锁\n" +
                "\t乐观锁   cas模式\n" +
                "\t\t自旋锁\n" +
                "\t\t进行循环 获取直到设置成功\n" +
                "\t悲观锁   重锁\n" +
                "\n" +
                "\n" +
                "\t公平锁\n" +
                "\t\t多个线程进入一个队列  进行逐个获取锁   资源浪费大  但是 不存在长时间获取不到锁的问题\n" +
                "\t非公平锁\n" +
                "\t\t多个线程抢锁  避免线程的休眠和线程的唤醒  资源浪费少  速度快  可能存在长时间获取不到锁\n" +
                "java线程池\n" +
                "\tcorePoolSize   正常数量\n" +
                "\tmaxPoolSize   最大线程数量";
        String b = "https://www.cnblogs.com/dafanjoy/p/9729358.html";
        String c = "https://www.cnblogs.com/dafanjoy/p/9729358.html";

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
