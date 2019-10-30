package edu.chat.server;

import java.io.*;
import java.net.*;

public class Server {

	private Socket socket;
	private ServerSocket serverSocket;
	private PrintWriter out;
	private BufferedReader in;
	private BufferedReader text;
	private final int port = 6000;

	public Server() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Waiting for connection");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + "is connected");
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			text = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		String sentMessage = null;
		String clientMessage = "";
		try {
			while (true) {
				if (in.ready()) {
					clientMessage = in.readLine();
					System.out.println(clientMessage);
				}
				if (clientMessage.equals("BYE") || clientMessage.equals("QUIT")) {
					System.out.println("Connection Terminated");
					socket.close();
					out.close();
					in.close();
					text.close();
					break;
				}
				if (!in.ready()) {
					if (sentMessage != null)
						out.println(sentMessage);
					sentMessage = text.readLine();
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}
