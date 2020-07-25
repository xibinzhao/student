package cn.linguy.student.singLeton;

public class SingLetonDemo1 {
    private static SingLetonDemo1 instance = new SingLetonDemo1();

    private SingLetonDemo1(){
        System.out.println(Thread.currentThread().getName()+"/t 创建了SingLetonDemo");
    }
    public static  SingLetonDemo1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                getInstance();
                System.out.println(getInstance());
            },String.valueOf(i)).start();
        }

    }
}
