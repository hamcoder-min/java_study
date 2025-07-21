package chapter17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 멀티 채팅 서버 구현
 */

public class Server {

	public final static int PORT = 9000;
	public static ArrayList<ClientHandler> list = new ArrayList<ClientHandler>();
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행중 : " + PORT);
			System.out.println("클라이언트 접속 대기 중~");
			
			while(true) {
				Socket s = server.accept();	//클라이언트 접속 대기 중
				System.out.println("✅클라이언트 접속!!");
				
				//클라이언트 별로 접속하고 별도 종료 진행!!!
				ClientHandler ch = new ClientHandler(s);
				list.add(ch);
				ch.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//Server


class ClientHandler extends Thread {
	Socket s;
	DataOutputStream output;
	DataInputStream input;
	
	public ClientHandler(Socket s) {
		try {
			this.s = s;
			this.output = new DataOutputStream(s.getOutputStream());	//전송 	서버가 out을 먼저 만들면 클라이언트는 in을 먼저 만들어야함! out/out 만들면 둘다 보내기만 하고 수신이 없기때문
			this.input = new DataInputStream(s.getInputStream());		//수신
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