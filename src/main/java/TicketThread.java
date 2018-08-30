/**
 * Created by woody on 2017/3/16.
 */
public class TicketThread extends Thread{

    private int ticket = 10;

    public void run(){
        for(int i =0;i<10;i++){
//            synchronized (this){
                if(this.ticket>0){
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+"sell---->"+(this.ticket--));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//            }
        }
    }

    public static void main(String[] arg){
        TicketThread t1 = new TicketThread();
        new Thread(t1,"thread1").start();
        new Thread(t1,"thread2").start();
        //此处网上有各种写法，很多写法都是自圆其说，举一些特殊例子来印证自己的观点，然而事实却不尽如此。
    }
}
