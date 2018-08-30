import java.io.BufferedReader;
import java.io.FileReader;

public class Main implements Runnable {

    @Override
    public void run() {
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("test.txt").toURI().getPath();
            System.out.println(Thread.currentThread().getName() + "运行:" + path);

            BufferedReader br = new BufferedReader(new FileReader(path));
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s = br.readLine()) != null) {
                sb.append(s + "\n");
            }
            System.out.println(sb.toString());
            Thread.sleep(10000000);
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        Main main = new Main();


        System.out.println("args = [" + 1341341341 + "]");
        new Thread(main,"线程1");
        new Thread(main,"线程2");
    }
}
