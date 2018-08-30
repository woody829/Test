import java.io.*;

/**
 * Created by woody on 2017/5/28.
 */
public class Test {

    private static void testUTF() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(
                    new File("testtt.txt")));
            dos.writeUTF("png");

            DataInputStream dis = new DataInputStream(new FileInputStream(
                    new File("testtt.txt")));
            byte[] data = new byte[dis.available()];
            dis.read(data);
            for (byte b : data) {
                System.out.println(Integer.toHexString(b & 0xFF) + "  ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testByte1() throws UnsupportedEncodingException {
        String string = "中国123";
        byte [] bytes = string.getBytes("GB2312");
        for (int i = 0 ; i< bytes.length ; i++){
            System.out.print(bytes[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        byte[] a = new byte[10];
        a[0]= -127;
        System.out.println(a[0]);
        int c = a[0]&0xff;
        System.out.println(c);



        testUTF();


    }
}

// http://www.cnblogs.com/think-in-java/p/5527389.html
//http://www.longdw.com/java-char-ascii-byte-writeutf-readutf/  AsCII
