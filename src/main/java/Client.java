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
	//���췽�����쳣һ��������,new�����ʱ��һ������
	Client() throws UnknownHostException, IOException{
		System.out.println("�������ӷ����...");
		socket=new Socket("192.168.199.111",8088);
		System.out.println("�����ӷ�����!");
	}
	void start() {
		ServerHandler handler=new ServerHandler();
		Thread t=new Thread(handler);
		/**
		 * start()��������,������main���߳�
		 * run()��������runnable״̬
		 */
		t.start();

		try {
			// �����������
			OutputStream out=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(out,"gbk");
			PrintWriter pw=new PrintWriter(osw,true);

			// ��ӡ�������
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
				// ���������������
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
