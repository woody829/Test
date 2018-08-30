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
		System.out.println("正在初始化服务端...");
		serverSocket=new ServerSocket(8088);
		System.out.println("服务端初始化完毕!");
	}

	void start() {
		while(true) {
			try {
				System.out.println("等待客户端连接...");
				Socket socket=serverSocket.accept();
				System.out.println("一个客户端连接了!");

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
			//获取远程计算机的地址信息
			InetAddress address=socket.getInetAddress();
			//获取远端计算机IP地址的字符串格式
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
				System.out.println("当前在线人数:"+allOut.length);

				String message=null;
				while((message=br.readLine())!=null) {
					System.out.println(host+"说:"+message);

					for(int i=0;i<allOut.length;i++) {
						allOut[i].println(host+"说:"+message);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				System.out.println("一个客户端下线了");
				for(int i=0;i<allOut.length;i++) {
					if(allOut[i]==pw) {//比较数组元素(引用类型对象)地址
						allOut[i]=allOut[allOut.length-1];
						allOut=Arrays.copyOf(allOut, allOut.length-1);
						break;
					}
				}
				System.out.println("当前在线人数:"+allOut.length);
			}
		}
	}
}


