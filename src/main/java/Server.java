import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
public class Server {
	private ServerSocket serverSocket;
	private PrintWriter[] allOut= {};
	Server() throws IOException{
		System.out.println("���ڳ�ʼ�������...");
		serverSocket=new ServerSocket(8088);
		System.out.println("����˳�ʼ�����!");
	}

	void start() {
		while(true) {
			try {
				System.out.println("�ȴ��ͻ�������...");
				Socket socket=serverSocket.accept();
				System.out.println("һ���ͻ���������!");

				ClientHandler handler=new ClientHandler(socket);
				Thread t=new Thread(handler);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			Server server=new Server();
			System.out.println("bingoooo");
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ClientHandler implements Runnable{
		private Socket socket;
		private String host;
		ClientHandler(Socket socket){
			this.socket=socket;
			//��ȡԶ�̼�����ĵ�ַ��Ϣ
			InetAddress address=socket.getInetAddress();
			//��ȡԶ�˼����IP��ַ���ַ�����ʽ
			host=address.getHostAddress();
		}
		public void run() {
			PrintWriter pw=null;
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(in,"gbk");
				BufferedReader br=new BufferedReader(isr);

				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(out,"gbk");
				pw=new PrintWriter(osw,true);

				allOut=Arrays.copyOf(allOut, allOut.length+1);
				allOut[allOut.length-1]=pw;
				System.out.println("��ǰ��������:"+allOut.length);

				String message=null;
				while((message=br.readLine())!=null) {
					System.out.println(host+"˵:"+message);

					for(int i=0;i<allOut.length;i++) {
						allOut[i].println(host+"˵:"+message);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				System.out.println("һ���ͻ���������");
				for(int i=0;i<allOut.length;i++) {
					if(allOut[i]==pw) {//�Ƚ�����Ԫ��(�������Ͷ���)��ַ
						allOut[i]=allOut[allOut.length-1];
						allOut=Arrays.copyOf(allOut, allOut.length-1);
						break;
					}
				}
				System.out.println("��ǰ��������:"+allOut.length);
			}
		}
	}
}


