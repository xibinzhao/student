package cn.linguy.student.singLeton;

public class SingLetonDemo {
    private static SingLetonDemo instance = null;

    private SingLetonDemo(){
        System.out.println(Thread.currentThread().getName()+"/t 创建了SingLetonDemo");
    }
    public static synchronized SingLetonDemo getInstance(){
        if (instance==null){
            instance = new SingLetonDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                getInstance();
            },String.valueOf(i)).start();
        }

    }
}
