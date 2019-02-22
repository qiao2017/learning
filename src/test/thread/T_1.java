package test.thread;

public class T_1 implements Runnable{
    private int count = 10;
    
    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.version"));
        T_1 t = new T_1();
        for(int i = 0; i < 10; i++) {
            new Thread(t, "THREAD_" + i).start();
        }
    }
    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName()
                + " count: " + count);
    }
}
