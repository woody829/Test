import java.io.InputStream;

/**
 * Created by woody on 2017/5/24.
 */
public class ByteTest {

    public static void main(String[] args) throws Exception{
        InputStream in = ByteTest.class.getResourceAsStream("/tt.txt");
        System.out.println(Integer.toHexString(1));
        byte[]tt=new byte[5];
        while(in.available()!=0){
            for(int i=0;i<5;i++){
                tt[i]=(byte)in.read();
                System.out.println(tt[i]);
            }
        }
        String ttttt=new String(tt,"utf-8");
        System.out.println(ttttt);
        in.close();
    }
}
