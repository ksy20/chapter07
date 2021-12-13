package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("====================================");
		System.out.println("[서버에 연결을 요청합니다]");
		
		socket.connect(new InetSocketAddress("192.168.0.60", 10001));
		
		System.out.println("[서버에 연결되었습니다]");
		
		OutputStream os = socket.getOutputStream();//주스트림
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8"); 
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			if("/q".equals(str)) {
				System.out.println("종료키 입력");
				break;
			}
			
			bw.write(str);
			bw.newLine();
			bw.flush();
			
			String remsg = br.readLine();
			System.out.println("server: ["+remsg+"]");
		}
		
		System.out.println("[클라이언트가 종료 되었습니다.]");
		sc.close();
		bw.close();
		socket.close();
	}

}
