package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
	private Socket socket;
	//构造方法的异常一律向外抛,new对象的时候一并处理
	Client() throws UnknownHostException, IOException{
		System.out.println("正在连接服务端...");
		socket=new Socket("192.168.199.111",8088);
		System.out.println("已连接服务器!");
	}
	void start() {
		ServerHandler handler=new ServerHandler();
		Thread t=new Thread(handler);
		/**
		 * start()方法调用,启动了main主线程
		 * run()方法处于runnable状态
		 */
		t.start();

		try {
			// 监听自身输出
			OutputStream out=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(out,"gbk");
			PrintWriter pw=new PrintWriter(osw,true);

			// 打印自身输出
			Scanner scan=new Scanner(System.in);
			while(true) {
				String line=scan.nextLine();
				pw.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ServerHandler implements Runnable{
		public void run() {
			try {
				// 监听服务器端输出
				InputStream in = socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(in,"gbk");
				BufferedReader br=new BufferedReader(isr);

				String message=null;
				while((message=br.readLine())!=null) {
					System.out.println(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			Client client=new Client();
			client.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
