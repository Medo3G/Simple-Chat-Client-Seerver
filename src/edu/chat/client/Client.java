package edu.chat.client;

import java.io.*;
import java.net.*;

public class Client {

	private Socket socket;
	private PrintWriter out;
	private BufferedReader serverInput;
	private BufferedReader userInput;
	private final int portNumber = 6000;

	public Client(String hostName) {
		try {
			System.out.println("Trying to connect to " + hostName + "...");
			socket = new Socket(hostName, portNumber);
			System.out.println("Successfully connected.");
			out = new PrintWriter(socket.getOutputStream(), true);
			serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			userInput = new BufferedReader(new InputStreamReader(System.in));
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		String userText = null;
		try {
			while (true) {
				if (serverInput.ready())
					System.out.println(serverInput.readLine());
				if (!serverInput.ready()) {
					if (userText != null) {
						out.println(userText);
						if (userText.equals("BYE") || userText.equals("QUIT")) {
							break;
						}
					}
					userText = userInput.readLine();
				}
			}
			socket.close();
			System.out.println("Connection terminated");
			out.close();
			serverInput.close();
			userInput.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the IP of the sever:");
		try {
			String hostNname = bf.readLine();
			new Client(hostNname);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
