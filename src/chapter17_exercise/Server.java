package chapter17_exercise;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	public final static int PORT = 9000;
	public static ArrayList<ClientHandler> list = new ArrayList<ClientHandler>();
	

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행중 : " + PORT);
			System.out.println("클라이언트 접속 대기 중~");
			
			while(true) {
				Socket s = server.accept();
				System.out.println("✅클라이언트 접속!!");
				
				ClientHandler ch = new ClientHandler(s);
				list.add(ch);
				ch.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}

class ClientHandler extends Thread {
	Socket s;
	DataOutputStream output;
	DataInputStream input;
	
	public ClientHandler (Socket s) {
		try {
			this.s = s;
			this.output = new DataOutputStream(s.getOutputStream());
			this.input = new DataInputStream(s.getInputStream());
			String str = "[서버] 환영합니다~^^";
			output.writeUTF(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			boolean flag = true;
			while(flag) {
				String receivedMsg = input.readUTF();
				if(receivedMsg.equals("exit")) {
					System.out.println("클라이언트 종료!!");
					Server.list.remove(this);
					flag = false;
				} else {
					Server.list.forEach(ch -> {
						try {
							ch.output.writeUTF(receivedMsg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
