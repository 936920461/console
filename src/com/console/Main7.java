package com.console;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main7 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket();
		if (!serverSocket.isBound()) {
			serverSocket.bind(new InetSocketAddress(8080));
			System.out.println("服务端启动成功！");
		}
		while (true) {
			Socket socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(is);
			// BufferedReader buffer=new BufferedReader(reader);
			char[] array = new char[1024];
			int count = reader.read(array);
			if (count > 0) {
				System.out.println(new String(array));
				reader.close();
				is.close();
			}
		}
	}

}
