package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
			
		ServerSocket serverSocket= new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.60", 10001));
		
		System.out.println("<서버 시작>");
		System.out.println("====================================");
		System.out.println("[연결을 기다리고있습니다.]");
		
		while(true) {
			
			Socket socket = serverSocket.accept();
			
			Thread thread = new ServerThread(socket);//전화번호전달 출장코드 회선강화3단 메세지주고받기
			thread.start(); //출장나가고 선보강 메세지주고받기 출장종료
//			if () {
//				break;
//			}
		}
		

		//System.out.println("<서버 종료>");
		//serverSocket.close();
	
	}



}
