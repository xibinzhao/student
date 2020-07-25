package cn.linguy.student.singLeton;

public class SingLetonDemo2 {


    private SingLetonDemo2() throws InterruptedException {
        Thread.sleep(1000*20);
        System.out.println(Thread.currentThread().getName()+"/t 创建了SingLetonDemo");
    }
    public static SingLetonDemo2 getInstance(){
        return ab.instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                getInstance();
                System.out.println(getInstance());
            },String.valueOf(i)).start();
        }

    }
    private static class ab{
        private static SingLetonDemo2 instance;
        static {
            try {
                instance = new SingLetonDemo2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
