package demothread;

public class Main {
    public static void main(String[] args){
        SubThread1 s = new SubThread1();//30
        s.setDaemon(true);
        SubRunnable r = new SubRunnable();
        Thread t = new Thread(r);//20
       // t.setDaemon(true);
        s.start();
        t.start();
    }
    public static void main2(String[] args){
        // Thread
        SubThread1 st1 = new SubThread1();
        st1.start();
        // Runnable
        SubRunnable r = new SubRunnable();
        Thread t = new Thread(r);
        t.start();
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
            }
        };
        Thread t2 = new Thread(r2);
        t2.start();


        new Thread(()->{
            for (int i=0;i<20;i++){
                System.out.println("R i = "+i);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
            System.out.println("R Done");
        }).start();


        for (int i=0;i<20;i++){
            System.out.println("Main i = "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
        System.out.println("Main Done");
    }
}
