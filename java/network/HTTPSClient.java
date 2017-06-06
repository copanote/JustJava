package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HTTPSClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		if (args.length == 0) {
			System.out.println("Usage: java HTTPSClient2 host");
			return;
		}*/
		
		int port = 443; //https default port 
		String host = "www.usps.com";
		
		SSLSocketFactory factory =(SSLSocketFactory)SSLSocketFactory.getDefault();
		SSLSocket socket = null;
		
		try {
			socket =  (SSLSocket)factory.createSocket(host, port);
			HandshakeListenr event = new HandshakeListenr();
			socket.addHandshakeCompletedListener(event);
			
			//��� ��ȣȭ ������ ����ϵ��� ���� 
			String[] supported = socket.getSupportedCipherSuites();
			socket.setEnabledCipherSuites(supported);	
			
			Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			//https�� get ��û�� ��ü URL�� ����Ѵ�. 
			out.write("GET http://" + host + "/ HTTP/1.1\r\n");
			out.write("Host: " + host + "\r\n");
			out.write("\r\n");
			out.flush();
			
			//���� �б�
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//��� �б�
			String s;
			while (!(s = in.readLine()).equals("")) {
				System.out.println(s);
			}
			System.out.println();
			
			//���� �б�
			String contentLength = in.readLine();
			int length = Integer.MAX_VALUE;
			try {
				length = Integer.parseInt(contentLength.trim(), 16);
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			System.out.println(contentLength);
			
			
			int c;
			int i = 0;
			while( ( c = in.read()) != -1 && i++ <length) {
				System.out.write(c);
			}
			System.out.println();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch(IOException e) {}
		}

	}
}

class HandshakeListenr implements HandshakeCompletedListener{

	@Override
	public void handshakeCompleted(HandshakeCompletedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("EVENT");
		
	}
	
}

